package com.jixiao.api.modular.user.controller;

import com.jixiao.api.core.annotation.RequireUser;
import com.jixiao.api.modular.user.service.IUserService;
import com.jixiao.common.ErrorCode;
import com.jixiao.common.JsonResult;
import com.jixiao.common.base.BaseController;
import com.jixiao.common.util.AccountValidatorUtil;
import com.jixiao.common.util.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiang
 * @since 2018-09-20
 */
@Api(tags = "请先登录", description = "LoginController")
@RestController
public class LoginController extends BaseController {

    @Autowired
    private IUserService userService;

    @ApiOperation(value = "登录", notes = "登录操作")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "账号", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "code", value = "验证码", dataType = "String", paramType = "query")
    })
    @PostMapping("/login")
    public JsonResult login(String username, String password, String code) {
        if (!AccountValidatorUtil.validateMobile(username)) {
            return JsonResult.failure(ErrorCode.BAD_REQUEST, "输入的手机号有误");
        }
        if (StringUtil.isBlank(password) && StringUtil.isBlank(code)) {
            return JsonResult.failure(ErrorCode.BAD_REQUEST);
        }
        return userService.login(username, password, code, request, response);
    }

    @ApiOperation(value = "退出(user)", notes = "退出操作")
    @RequireUser
    @DeleteMapping("/logoff")
    public JsonResult logoff() {
        return userService.logoff(request, response);
    }

}
