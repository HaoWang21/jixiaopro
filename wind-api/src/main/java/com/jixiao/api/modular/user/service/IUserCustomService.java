package com.jixiao.api.modular.user.service;

import com.jixiao.common.JsonResult;

/**
 * @author jiang
 * @since 2018-09-28
 */
public interface IUserCustomService {

    /**
     * 点赞/收藏
     *
     * @param userDynamicId 动态Id
     * @param type 类型：0点赞 1收藏
     * @param userId 用户Id
     * @return json
     */
    JsonResult saveOrRemove(Long userDynamicId, Integer type, Long userId);

}
