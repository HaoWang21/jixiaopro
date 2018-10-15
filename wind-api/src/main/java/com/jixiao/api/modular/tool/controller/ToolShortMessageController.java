package com.jixiao.api.modular.tool.controller;

import com.jixiao.common.ErrorCode;
import com.jixiao.common.JsonResult;
import com.jixiao.api.modular.tool.service.IToolShortMessageService;
import com.jixiao.common.util.AccountValidatorUtil;
import com.jixiao.common.util.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.jixiao.common.base.BaseController;

/**
 * @author jiang
 * @since 2018-09-28
 */
@Api(tags = "短信", description = "ToolShortMessageController")
@RestController
@RequestMapping("/shortMessage")
public class ToolShortMessageController extends BaseController {

    @Autowired
    private IToolShortMessageService toolShortMessageService;

    @ApiOperation(value = "验证码", notes = "获取验证码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "mobile", value = "手机号", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "type", value = "类型：0注册 1登录 2修改密码 3找回密码", required = true, dataType = "int", paramType = "query")
    })
    @PostMapping
    public JsonResult save(String mobile, Integer type) {
        if (!AccountValidatorUtil.validateMobile(mobile)) {
            return JsonResult.failure(ErrorCode.BAD_REQUEST, "输入的手机号有误");
        }
        return toolShortMessageService.save(mobile, type);
    }
}
