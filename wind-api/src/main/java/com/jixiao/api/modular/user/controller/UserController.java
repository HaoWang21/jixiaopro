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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiang
 * @since 2018-09-28
 */
@Api(tags = "用户", description = "UserController")
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private IUserService userService;

    @ApiOperation(value = "注册", notes = "注册一个号")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "账号", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "code", value = "验证码", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "refereeCode", value = "邀请码", dataType = "String", paramType = "query")
    })
    @PostMapping
    public JsonResult register(String username, String password, String code, String refereeCode) {
        if (!AccountValidatorUtil.validateMobile(username)) {
            return JsonResult.failure(ErrorCode.BAD_REQUEST, "输入的手机号有误");
        }
        if (!AccountValidatorUtil.validatePassword(password)) {
            return JsonResult.failure(ErrorCode.BAD_REQUEST, "输入的密码格式错误");
        }
        if (code.length() != 6) {
            return JsonResult.failure(ErrorCode.BAD_REQUEST, "输入的验证码有误");
        }
        if (StringUtil.isNotBlank(refereeCode) && refereeCode.length() != 8) {
            return JsonResult.failure(ErrorCode.BAD_REQUEST, "输入的邀请码有误");
        }
        return userService.register(username, password, code, refereeCode, request, response);
    }

    @ApiOperation(value = "修改密码(user)", notes = "通过原密码修改密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "originalPassword", value = "旧密码", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String", paramType = "query"),
    })
    @RequireUser
    @PutMapping("/changePassword")
    public JsonResult changePassword(String originalPassword, String password) {
        if (!AccountValidatorUtil.validatePassword(originalPassword) || !AccountValidatorUtil.validatePassword(password)) {
            return JsonResult.failure(ErrorCode.BAD_REQUEST, "输入的密码格式错误");
        }
        return userService.changePassword(originalPassword, password, getUserId(), request, response);
    }
}
