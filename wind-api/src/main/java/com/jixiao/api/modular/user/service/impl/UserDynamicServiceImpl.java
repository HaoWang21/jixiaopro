package com.jixiao.api.modular.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.jixiao.api.core.exception.DiyException;
import com.jixiao.api.modular.user.service.IUserCommentService;
import com.jixiao.api.modular.user.service.IUserDynamicService;
import com.jixiao.common.ErrorCode;
import com.jixiao.common.JsonResult;
import com.jixiao.common.util.DateUtil;
import com.jixiao.common.util.StringUtil;
import com.jixiao.user.entity.*;
import com.jixiao.user.entity.dto.UserDynamicContentDTO;
import com.jixiao.user.entity.dto.UserDynamicContentImageDTO;
import com.jixiao.user.entity.dto.UserDynamicContentVideoDTO;
import com.jixiao.user.entity.vo.UserCommentVO;
import com.jixiao.user.entity.vo.UserDynamicDetailsVO;
import com.jixiao.user.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author jiang
 * @since 2018-09-28
 */
@Service
public class UserDynamicServiceImpl implements IUserDynamicService {

    @Autowired
    private IUserDynamicMapper userDynamicMapper;
    @Autowired
    private IUserDynamicSettingsMapper userDynamicSettingsMapper;
    @Autowired
    private IUserUploadMapper userUploadMapper;
    @Autowired
    private IUserFollowMapper userFollowMapper;
    @Autowired
    private IUserCommentMapper userCommentMapper;
    @Autowired
    private IUserCommentService userCommentService;

    @Transactional(rollbackFor = DiyException.class)
    @Override
    public JsonResult save(UserDynamicContentDTO dto, Long userId) {
        if (StringUtil.isBlank(dto.getContent())) {
            return JsonResult.failure(ErrorCode.BAD_REQUEST);
        }

        UserDynamic.Builder userDynamicBuilder = new UserDynamic.Builder().userId(userId).type(0)
                .content(StringUtil.encodeBase64String(dto.getContent()));
        if (null != dto.getTypeId()) {
            userDynamicBuilder.typeToolDictId(dto.getTypeId());
        }

        UserDynamic userDynamic = userDynamicBuilder.build();
        // 保存动态
        userDynamicMapper.insert(userDynamic);
        // 保存动态设置
        saveUserDynamic(userDynamic.getId(), dto.getBrowse(), dto.getLng(), dto.getLat(), dto.getAddress(), dto.getAteUserIds(), userId);

        return JsonResult.success();
    }

    @Transactional(rollbackFor = DiyException.class)
    @Override
    public JsonResult save(UserDynamicContentImageDTO dto, Long userId) {
        if (StringUtil.isBlank(dto.getUploadIds())) {
            return JsonResult.failure(ErrorCode.BAD_REQUEST);
        }
        String[] ids = dto.getUploadIds().split(",");
        List<UserUpload> list = userUploadMapper.selectListByUserIdAndIds(userId, ids);
        if (ids.length != list.size()) {
            return JsonResult.failure(ErrorCode.BAD_REQUEST);
        }

        UserDynamic.Builder userDynamicBuilder = new UserDynamic.Builder().userId(userId).type(1);
        if (StringUtil.isNotBlank(dto.getContent())) {
            userDynamicBuilder.content(StringUtil.encodeBase64String(dto.getContent()));
        }
        if (null != dto.getTypeId()) {
            userDynamicBuilder.typeToolDictId(dto.getTypeId());
        }

        UserDynamic userDynamic = userDynamicBuilder.build();
        // 保存动态
        userDynamicMapper.insert(userDynamic);
        // 保存动态设置
        saveUserDynamic(userDynamic.getId(), dto.getBrowse(), dto.getLng(), dto.getLat(), dto.getAddress(), dto.getAteUserIds(), userId);
        // 绑定资源
        for (String id : ids) {
            userUploadMapper.updateById(new UserUpload.Builder().id(Long.valueOf(id)).userDynamicId(userDynamic.getId()).build());
        }

        return JsonResult.success();
    }

    @Transactional(rollbackFor = DiyException.class)
    @Override
    public JsonResult save(UserDynamicContentVideoDTO dto, Long userId) {
        if (null == dto.getUploadId()) {
            return JsonResult.failure(ErrorCode.BAD_REQUEST);
        }
        UserUpload userUpload = userUploadMapper.selectOne(new LambdaQueryWrapper<UserUpload>()
                .eq(UserUpload::getId, dto.getUploadId()).eq(UserUpload::getUserId, userId));
        if (null == userId) {
            return JsonResult.failure(ErrorCode.BAD_REQUEST);
        }

        UserDynamic.Builder userDynamicBuilder = new UserDynamic.Builder().userId(userId).type(2);
        if (StringUtil.isNotBlank(dto.getContent())) {
            userDynamicBuilder.content(StringUtil.encodeBase64String(dto.getContent()));
        }
        if (null != dto.getTypeId()) {
            userDynamicBuilder.typeToolDictId(dto.getTypeId());
        }

        UserDynamic userDynamic = userDynamicBuilder.build();
        // 保存动态
        userDynamicMapper.insert(userDynamic);
        // 保存动态设置
        saveUserDynamic(userDynamic.getId(), dto.getBrowse(), dto.getLng(), dto.getLat(), dto.getAddress(), dto.getAteUserIds(), userId);
        // 绑定资源
        userUploadMapper.updateById(new UserUpload.Builder().id(userUpload.getId()).userDynamicId(userDynamic.getId()).build());

        return JsonResult.success();
    }

    @Override
    public JsonResult remove(Long id, Long userId) {
        UserDynamic userDynamic = userDynamicMapper.selectById(id);
        if (null == userDynamic || userDynamic.getDelFlag() || !userDynamic.getUserId().equals(userId)) {
            return JsonResult.failure(ErrorCode.BAD_REQUEST);
        }
        userDynamicMapper.updateById(new UserDynamic.Builder().id(id).delFlag(true).build());
        return JsonResult.success();
    }

    @Override
    public JsonResult details(Long id, Long userId) {
        UserDynamicDetailsVO vo = userDynamicMapper.selectVoDetailsById(id, userId);
        if (null == vo) {
            return JsonResult.failure(ErrorCode.BAD_REQUEST);
        }

        if (StringUtil.isNotBlank(vo.getNickName())) {
            vo.setNickName(StringUtil.decodeBase64(vo.getNickName()));
        }
        if (StringUtil.isNotBlank(vo.getContent())) {
            vo.setContent(StringUtil.decodeBase64(vo.getContent()));
        }
        if (vo.getType() != 0) {
            vo.setUrlList(userUploadMapper.selectStringListByUserDynamicId(vo.getId()));
        }
        vo.setCommentVOList(userCommentService.listByUserDynamicId(vo.getId()));

        return JsonResult.success(vo);
    }

    /**
     * 确认@的人是关注的人
     *
     * @param ateUserIds @谁
     * @param userId     用户Id
     * @return boolean
     */
    private boolean checkMyFollow(String ateUserIds, Long userId) {
        if (StringUtil.isBlank(ateUserIds)) {
            return false;
        }
        String[] userIds = ateUserIds.split(",");
        List<UserFollow> followList = userFollowMapper.selectListByUserIdAndIds(userId, ateUserIds);
        if (userIds.length != followList.size()) {
            throw new DiyException(ErrorCode.BAD_REQUEST);
        }
        return true;
    }

    /**
     * 通用保存动态配置信息
     *
     * @param userDynamicId 动态Id
     * @param browse        那些人可以查看这条动态
     * @param lng           经度
     * @param lat           纬度
     * @param address       地址
     * @param ateUserIds    @谁
     * @param userId        用户Id
     */
    private void saveUserDynamic(Long userDynamicId, String browse, BigDecimal lng, BigDecimal lat, String address,
                                 String ateUserIds, Long userId) {
        UserDynamicSettings.Builder builder = new UserDynamicSettings.Builder().userDynamicId(userDynamicId).browse(browse);
        if (null != lng && null != lat && StringUtil.isNotBlank(address)) {
            builder.lng(lng).lat(lat).address(address);
        }
        if (checkMyFollow(ateUserIds, userId)) {
            builder.ateUserId(ateUserIds);
        }
        // 保存动态设置
        userDynamicSettingsMapper.insert(builder.build());
    }
}
