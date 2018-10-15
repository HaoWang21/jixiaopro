package com.jixiao.api.modular.user.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.lock.annotation.Lock4j;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.jixiao.api.core.exception.DiyException;
import com.jixiao.api.modular.user.service.IUserSignInService;
import com.jixiao.api.modular.user.service.IUserWalletService;
import com.jixiao.common.ErrorCode;
import com.jixiao.common.JsonResult;
import com.jixiao.common.global.Constant;
import com.jixiao.user.entity.UserSignIn;
import com.jixiao.user.entity.UserWallet;
import com.jixiao.user.entity.vo.UserSignInDetailsVO;
import com.jixiao.user.entity.vo.UserSignInListVO;
import com.jixiao.user.mapper.IUserSignInMapper;
import com.jixiao.user.mapper.IUserWalletMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.List;

/**
 * @author jiang
 * @since 2018-09-28
 */
@Service
public class UserSignInServiceImpl implements IUserSignInService {

    @Autowired
    private IUserSignInMapper userSignInMapper;
    @Autowired
    private IUserWalletMapper userWalletMapper;
    @Autowired
    private IUserWalletService userWalletService;

    @Lock4j(keys = {"#userId"}, expire = 30000, tryTimeout = 1000)
    @Transactional(rollbackFor = DiyException.class)
    @Override
    public JsonResult save(Long userId) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DATE);

        UserSignIn signIn = userSignInMapper.selectOneByUserIdAndDate(userId, year, month, day);
        if (null != signIn) {
            return JsonResult.failure(ErrorCode.BAD_REQUEST);
        }

        // 今天没签到，查询昨天的记录
        calendar.set(Calendar.DATE, day - 1);
        signIn = userSignInMapper.selectOneByUserIdAndDate(userId, calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DATE));
        // 如果有 +1 否则从1开始
        int continuityNail = (null == signIn ? 1 : signIn.getContinuity() + 1);

        // 连续签到规则(铜币值)
        int copperCoin = continuityNail >= Constant.MAX_SIGN_IN_DAT ? Constant.MAX_SIGN_IN_DAT : continuityNail;
        // 添加签到记录
        userSignInMapper.insert(new UserSignIn.Builder().userId(userId).year(year).month(month).day(day)
                .continuity(continuityNail).copperCoin(copperCoin).build());

        // TODO 操作钱包
        JSONObject json = new JSONObject();
        json.put(Constant.COPPER_COIN, copperCoin);
        json.put(Constant.REMARK, String.format("连续签到%s天，获得%s个铜币", continuityNail, copperCoin));
        userWalletService.updateUserWalletYouHaveToBeCareful(userId, json);

        return JsonResult.success();
    }

    @Override
    public JsonResult details(Long userId) {
        UserWallet userWallet = userWalletMapper.selectOne(new LambdaQueryWrapper<UserWallet>()
                .eq(UserWallet::getUserId, userId).eq(UserWallet::getDelFlag, 0));

        List<UserSignInListVO> list = userSignInMapper.selectVoListByUserId(userId);

        boolean check = false;
        int nowCopperCoin = 1;
        int continuityNail = 0;

        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DATE);
        UserSignIn signIn = userSignInMapper.selectOneByUserIdAndDate(userId, calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH) + 1, day);
        if (null != signIn) {
            check = true;
            continuityNail = signIn.getContinuity();
            nowCopperCoin = signIn.getCopperCoin();
        } else {
            // 今天没签到，查询昨天的记录
            calendar.set(Calendar.DATE, day - 1);
            signIn = userSignInMapper.selectOneByUserIdAndDate(userId, calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DATE));
            if (null != signIn) {
                continuityNail = signIn.getContinuity();

                // 连续签到规则(铜币值)
                nowCopperCoin = (continuityNail + 1) >= Constant.MAX_SIGN_IN_DAT ? Constant.MAX_SIGN_IN_DAT : continuityNail;
            }
        }

        UserSignInDetailsVO vo = new UserSignInDetailsVO();
        vo.setCheck(check);
        vo.setCopperCoin(userWallet.getCopperCoin());
        vo.setNowCopperCoin(nowCopperCoin);
        vo.setContinuityNail(continuityNail);
        vo.setContinuityCopperCoin(list.stream().mapToInt(UserSignInListVO::getCopperCoin).sum());
        vo.setList(list);
        return JsonResult.success(vo);
    }
}
