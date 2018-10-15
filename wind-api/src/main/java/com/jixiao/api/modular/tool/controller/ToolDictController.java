package com.jixiao.api.modular.tool.controller;

import com.jixiao.api.modular.tool.service.IToolDictService;
import com.jixiao.common.ErrorCode;
import com.jixiao.common.JsonResult;
import com.jixiao.common.base.BaseController;
import com.jixiao.common.global.Constant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiang
 * @since 2018-09-28
 */
@Api(tags = "字典", description = "ToolDictController")
@RestController
@RequestMapping("/toolDict")
public class ToolDictController extends BaseController {

    @Autowired
    private IToolDictService toolDictService;

    @ApiOperation(value = "列表", notes = "查询列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "labelKey", value = "标签：index主页标签", required = true, dataType = "String", paramType = "query")
    })
    @GetMapping("/list")
    public JsonResult list(String labelKey) {
        String key;
        switch (labelKey) {
            case "index":
                key = Constant.INDEX_LABEL;
                break;
            default:
                return JsonResult.failure(ErrorCode.BAD_REQUEST);
        }
        return toolDictService.list(key);
    }

}
