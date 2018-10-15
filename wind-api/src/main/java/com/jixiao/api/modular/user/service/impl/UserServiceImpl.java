package com.jixiao.api.modular.user.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.lock.annotation.Lock4j;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.jixiao.api.core.exception.DiyException;
import com.jixiao.api.modular.tool.service.IToolDictService;
import com.jixiao.api.modular.user.service.IUserService;
import com.jixiao.api.modular.user.service.IUserWalletService;
import com.jixiao.common.ErrorCode;
import com.jixiao.common.JsonResult;
import com.jixiao.common.global.Constant;
import com.jixiao.common.util.*;
import com.jixiao.tool.entity.ToolShortMessage;
import com.jixiao.tool.mapper.IToolShortMessageMapper;
import com.jixiao.user.entity.User;
import com.jixiao.user.entity.UserInfo;
import com.jixiao.user.entity.UserPrivacySettings;
import com.jixiao.user.entity.UserWallet;
import com.jixiao.user.entity.vo.UserInfoVO;
import com.jixiao.user.mapper.IUserInfoMapper;
import com.jixiao.user.mapper.IUserMapper;
import com.jixiao.user.mapper.IUserPrivacySettingsMapper;
import com.jixiao.user.mapper.IUserWalletMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jiang
 * @since 2018-09-28
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private IUserMapper userMapper;
    @Autowired
    private IUserInfoMapper userInfoMapper;
    @Autowired
    private IToolShortMessageMapper toolShortMessageMapper;
    @Autowired
    private IUserWalletMapper userWalletMapper;
    @Autowired
    private IUserPrivacySettingsMapper userPrivacySettingsMapper;
    @Autowired
    private IUserWalletService userWalletService;
    @Autowired
    private IToolDictService toolDictService;

    @Lock4j(keys = {"#username"}, expire = 30000, tryTimeout = 1000)
    @Override
    public JsonResult login(String username, String password, String code, HttpServletRequest request, HttpServletResponse response) {
        Object userId = request.getSession().getAttribute(Constant.USER_ID);
        if (null != userId) {
            return JsonResult.failure(ErrorCode.BAD_REQUEST, "重复登录 wtf?");
        }

        User user = userMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getUsername, username).eq(User::getDelFlag, 0));
        if (null == user) {
            return JsonResult.failure(ErrorCode.BAD_REQUEST, "账号或密码错误");
        }
        if (user.getStatus() == 1) {
            return JsonResult.failure(ErrorCode.BAD_REQUEST, "账号已被禁用");
        }

        if (StringUtil.isNotBlank(password) && Md5Util.validatePassword(user.getPassword(), password + user.getSalt())) {
            return JsonResult.failure(ErrorCode.BAD_REQUEST, "账号或密码错误");
        }

        if (StringUtil.isNotBlank(code)) {
            ToolShortMessage shortMessage = toolShortMessageMapper.selectByMobileAndOtherAttribute(username, code, 1, 0);
            if (null == shortMessage) {
                return JsonResult.failure(ErrorCode.BAD_REQUEST, "验证码错误或已被使用");
            }
            if (DateUtil.subtract2Date(shortMessage.getGmtCreate()) > Constant.SMS_EXPIRE) {
                return JsonResult.failure(ErrorCode.BAD_REQUEST, "验证码已失效");
            }

            // 更新短信记录
            shortMessage.setStatus(1);
            toolShortMessageMapper.updateById(shortMessage);
        }
        return this.saveSession(user.getId(), request, response);
    }

    @Override
    public JsonResult logoff(HttpServletRequest request, HttpServletResponse response) {
        // 移除session
        request.getSession().removeAttribute(Constant.USER_ID);
        // 移除cookie
        CookieUtil.removeCookie(request, response, Constant.COOKIE_KEY);
        return JsonResult.success();
    }

    @Lock4j(keys = {"#username"}, expire = 30000, tryTimeout = 1000)
    @Transactional(rollbackFor = DiyException.class)
    @Override
    public JsonResult register(String username, String password, String code, String refereeCode,
                               HttpServletRequest request, HttpServletResponse response) {
        User user = userMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getUsername, username).eq(User::getDelFlag, 0));
        if (null != user) {
            return JsonResult.failure(ErrorCode.BAD_REQUEST, "账号已被注册");
        }

        ToolShortMessage shortMessage = toolShortMessageMapper.selectByMobileAndOtherAttribute(username, code, 0, 0);
        if (null == shortMessage) {
            return JsonResult.failure(ErrorCode.BAD_REQUEST, "验证码错误或已被使用");
        }
        if (DateUtil.subtract2Date(shortMessage.getGmtCreate()) > Constant.SMS_EXPIRE) {
            return JsonResult.failure(ErrorCode.BAD_REQUEST, "验证码已失效");
        }

        UserInfo refereeUserInfo = null;
        if (StringUtil.isNotBlank(refereeCode)) {
            refereeUserInfo = userInfoMapper.selectOne(new LambdaQueryWrapper<UserInfo>()
                    .eq(UserInfo::getRefereeCode, refereeCode).eq(UserInfo::getDelFlag, 0));
            if (null == refereeUserInfo) {
                return JsonResult.failure(ErrorCode.BAD_REQUEST, "邀请码错误");
            }
        }

        // 保存用户账号信息
        String salt = RandomUtil.generateString(8);
        user = new User.Builder().username(username).password(Md5Util.md5(password + salt)).salt(salt).createIp(RequestUtil.getRemoteAddr()).build();
        userMapper.insert(user);

        // 获取系统默认配置
        JSONObject config = toolDictService.selectDefaultConfig();

        // 组装用户信息
        String nickname = StringUtil.encodeBase64String(username.substring(0, 3) + "*****" + username.substring(8));
        UserInfo.Builder userInfo = new UserInfo.Builder().userId(user.getId())
                .nickName(nickname).refereeCode(RefereeCodeUtil.toSerialCode(user.getId().intValue()))
                .avatarUrl(config.getString(Constant.AVATAR_URL))
                .backdropUrl(config.getString(Constant.BACKDROP_URL))
                .avatarCaseUrl(config.getString(Constant.AVATAR_CASE_URL));

        // 发放邀请人奖励
        if (null != refereeUserInfo) {
            userInfo.refereeUserId(refereeUserInfo.getUserId());

            Integer integral = config.getInteger(Constant.REFEREE_REGISTER);
            // TODO 操作钱包
            JSONObject json = new JSONObject();
            json.put(Constant.COPPER_COIN, integral);
            json.put(Constant.REMARK, String.format("邀请好友注册，获得%s个铜币", integral));
            userWalletService.updateUserWalletYouHaveToBeCareful(refereeUserInfo.getUserId(), json);
        }

        // 保存用户信息
        userInfoMapper.insert(userInfo.build());

        // 创建用户隐私设置
        userPrivacySettingsMapper.insert(new UserPrivacySettings.Builder().userId(user.getId()).build());

        // 创建钱包
        userWalletMapper.insert(new UserWallet.Builder().userId(user.getId()).build());

        // 更新短信
        shortMessage.setStatus(1);
        toolShortMessageMapper.updateById(shortMessage);

        // 开服前多少名注册奖励
        List<User> list = userMapper.selectList(new LambdaQueryWrapper<User>().select(User::getId));
        if (list.size() <= config.getInteger(Constant.REGISTRATIONS)) {
            Integer integral = config.getInteger(Constant.REGISTER);
            // TODO 操作钱包
            JSONObject json = new JSONObject();
            json.put(Constant.COPPER_COIN, integral);
            json.put(Constant.REMARK, String.format("注册成功，获得%s个铜币", integral));
            userWalletService.updateUserWalletYouHaveToBeCareful(user.getId(), json);
        }

        return saveSession(user.getId(), request, response);
    }

    @Override
    public JsonResult changePassword(String originalPassword, String password, Long userId, HttpServletRequest request, HttpServletResponse response) {
        User user = userMapper.selectById(userId);

        if (Md5Util.validatePassword(user.getPassword(), originalPassword + user.getSalt())) {
            return JsonResult.failure(ErrorCode.BAD_REQUEST, "旧密码错误");
        }

        String salt = RandomUtil.generateString(8);
        user.setPassword(Md5Util.md5(password + salt));
        user.setSalt(salt);
        userMapper.updateById(user);

        // 退出登录
        logoff(request, response);

        return JsonResult.success();
    }

    /**
     * 我的用户信息
     *
     * @param userId 用户Id
     * @return vo
     */
    @Override
    public UserInfoVO userInfo(Long userId) {
        UserInfo userInfo = userInfoMapper.selectOne(new LambdaQueryWrapper<UserInfo>().eq(UserInfo::getUserId, userId)
                .eq(UserInfo::getDelFlag, 0));

        UserInfoVO vo = new UserInfoVO();
        vo.setNickName(StringUtil.decodeBase64(userInfo.getNickName()));
        vo.setAvatarUrl(userInfo.getAvatarUrl());
        vo.setGender(userInfo.getGender());
        vo.setRole(userInfo.getRole());
        vo.setAddress(userInfo.getAddress());
        return vo;
    }

    /**
     * 添加session
     *
     * @param userId   用户Id
     * @param request  请求对象
     * @param response 响应对象
     * @return json
     */
    @SuppressWarnings(value = "unchecked")
    private JsonResult saveSession(Long userId, HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        // 添加session
        session.setAttribute(Constant.USER_ID, userId);
        // 添加cookie
        CookieUtil.setCookie(response, Constant.COOKIE_KEY, session.getId(), Constant.COOKIE_EXPIRE);

        /*
         * 登录踢出了解一下
         */
        String userKey = Constant.KICK_OUT_KEY + Md5Util.md5(userId.toString());
        ValueOperations<String, Deque<Serializable>> opsForValue = redisTemplate.opsForValue();
        // 读取缓存，没有就存入
        Deque<Serializable> deque = opsForValue.get(userKey);
        // 如果此用户没有session队列，也就是还没有登录过，缓存中没有
        if (null == deque) {
            deque = new LinkedList<>();
        }
        // 如果队列里没有此sessionId
        if (!deque.contains(userKey)) {
            // 将sessionId存入队列
            deque.push(session.getId());
            // 将用户的sessionId队列缓存
            opsForValue.set(userKey, deque);
        }
        // 如果队列里的sessionId数超出最大会话数，开始踢人
        while (deque.size() > 1) {
            deque.removeLast();
            // 踢出后再更新下缓存队列
            opsForValue.set(userKey, deque);
        }

        return JsonResult.success(this.userInfo(userId));
    }

}
