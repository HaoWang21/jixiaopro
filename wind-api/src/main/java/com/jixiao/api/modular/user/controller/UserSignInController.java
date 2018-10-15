package com.jixiao.api.modular.user.controller;

import com.jixiao.api.core.annotation.RequireUser;
import com.jixiao.api.modular.user.service.IUserSignInService;
import com.jixiao.common.JsonResult;
import com.jixiao.common.base.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author jiang
 * @since 2018-09-28
 */
@Api(tags = "用户签到", description = "UserSignInController")
@RestController
@RequireUser
@RequestMapping("/userSignIn")
public class UserSignInController extends BaseController {

    @Autowired
    private IUserSignInService userSignInService;

    @ApiOperation(value = "签到(user)", notes = "签到领铜币")
    @PostMapping
    public JsonResult save() {
        return userSignInService.save(getUserId());
    }

    @ApiOperation(value = "详情(user)", notes = "查看签到信息")
    @GetMapping
    public JsonResult details() {
        return userSignInService.details(getUserId());
    }
}
