package com.jixiao.api.modular.user.service;

import com.jixiao.common.JsonResult;

/**
 * @author jiang
 * @since 2018-09-28
 */
public interface IUserSignInService {

    /**
     * 添加
     *
     * @param userId 用户Id
     * @return json
     */
    JsonResult save(Long userId);

    /**
     * 详情
     *
     * @param userId 用户Id
     * @return json
     */
    JsonResult details(Long userId);
}
