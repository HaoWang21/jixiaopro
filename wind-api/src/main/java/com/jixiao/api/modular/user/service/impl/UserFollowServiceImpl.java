package com.jixiao.api.modular.user.service.impl;

import com.baomidou.lock.annotation.Lock4j;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.jixiao.api.modular.user.service.IUserFollowService;
import com.jixiao.common.ErrorCode;
import com.jixiao.common.JsonResult;
import com.jixiao.user.entity.UserFollow;
import com.jixiao.user.entity.UserInfo;
import com.jixiao.user.mapper.IUserFollowMapper;
import com.jixiao.user.mapper.IUserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jiang
 * @since 2018-09-28
 */
@Service
public class UserFollowServiceImpl implements IUserFollowService {

    @Autowired
    private IUserFollowMapper userFollowMapper;
    @Autowired
    private IUserInfoMapper userInfoMapper;

    @Lock4j(keys = {"#userId"}, expire = 30000, tryTimeout = 1000)
    @Override
    public JsonResult saveOrRemove(Long followUserId, Long userId) {
        UserInfo userInfo = userInfoMapper.selectOne(new LambdaQueryWrapper<UserInfo>().eq(UserInfo::getUserId, followUserId));
        if (null == userInfo) {
            return JsonResult.failure(ErrorCode.BAD_REQUEST);
        }

        UserFollow userFollow = userFollowMapper.selectOne(new LambdaQueryWrapper<UserFollow>()
                .eq(UserFollow::getUserId, userId)
                .eq(UserFollow::getFollowUserId, followUserId)
                .eq(UserFollow::getDelFlag, 0));

        if (null == userFollow) {
            userFollowMapper.insert(new UserFollow.Builder().userId(userId).followUserId(followUserId).build());
        } else {
            userFollowMapper.deleteById(userFollow.getId());
        }
        return JsonResult.success();
    }
}
