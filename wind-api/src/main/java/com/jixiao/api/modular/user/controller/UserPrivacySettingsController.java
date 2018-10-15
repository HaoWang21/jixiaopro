package com.jixiao.api.modular.user.controller;

import com.jixiao.api.core.annotation.RequireUser;
import com.jixiao.api.modular.user.service.IUserPrivacySettingsService;
import com.jixiao.common.JsonResult;
import com.jixiao.common.base.BaseController;
import com.jixiao.user.entity.vo.UserPrivacySettingsDetailsVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiang
 * @since 2018-10-01
 */
@Api(tags = "用户隐私设置", description = "UserPrivacySettingsController")
@RestController
@RequireUser
@RequestMapping("/userPrivacySettings")
public class UserPrivacySettingsController extends BaseController {

    @Autowired
    private IUserPrivacySettingsService userPrivacySettingsService;

    @ApiOperation(value = "修改(user)", notes = "修改隐私设置")
    @PutMapping
    public JsonResult update(UserPrivacySettingsDetailsVO vo) {
        return userPrivacySettingsService.update(vo, getUserId());
    }

    @ApiOperation(value = "详情(user)", notes = "查询详情")
    @GetMapping
    public JsonResult<UserPrivacySettingsDetailsVO> details() {
        return userPrivacySettingsService.details(getUserId());
    }
}
