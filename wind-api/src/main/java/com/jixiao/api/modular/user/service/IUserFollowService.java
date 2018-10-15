package com.jixiao.api.modular.user.service;

import com.jixiao.common.JsonResult;

/**
 * @author jiang
 * @since 2018-09-28
 */
public interface IUserFollowService {

    /**
     * 关注
     *
     * @param followUserId 关注的用户Id
     * @param userId 用户Id
     * @param check 确认取消：0否 1是
     * @return json
     */
    JsonResult saveOrRemove(Long followUserId, Integer check, Long userId);

}
