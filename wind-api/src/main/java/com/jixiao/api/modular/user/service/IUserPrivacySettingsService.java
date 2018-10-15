package com.jixiao.api.modular.user.service;

import com.jixiao.common.JsonResult;
import com.jixiao.user.entity.vo.UserPrivacySettingsDetailsVO;

/**
 * @author jiang
 * @since 2018-10-01
 */
public interface IUserPrivacySettingsService {

    /**
     * 修改
     *
     * @param vo 数据传输对象
     * @param userId 用户Id
     * @return json
     */
    JsonResult update(UserPrivacySettingsDetailsVO vo, Long userId);

    /**
     * 详情
     *
     * @param userId 用户Id
     * @return json
     */
    JsonResult<UserPrivacySettingsDetailsVO> details(Long userId);
}
