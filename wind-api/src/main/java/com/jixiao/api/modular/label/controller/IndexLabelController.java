package com.jixiao.api.modular.label.controller;

import com.jixiao.api.core.annotation.RequireUser;
import com.jixiao.api.modular.label.service.IIndexLabelService;
import com.jixiao.api.modular.operate.service.IOperateBannerService;
import com.jixiao.common.ErrorCode;
import com.jixiao.common.JsonResult;
import com.jixiao.common.base.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author jiang
 * @since 2018-09-20
 */
@Api(tags = "首页", description = "IndexLabelController")
@RestController
@RequestMapping("/index")
public class IndexLabelController extends BaseController {

    @Autowired
    private IIndexLabelService indexLabelService;
    @Autowired
    private IOperateBannerService operateBannerService;

    @ApiOperation(value = "轮播/标签", notes = "轮播banner分类标签")
    @GetMapping("/carousel")
    public JsonResult carousel() {
        return operateBannerService.list();
    }

    @ApiOperation(value = "热门", notes = "热门的动态")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current", value = "页码", dataType = "long", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "size", value = "数量", dataType = "long", paramType = "query", defaultValue = "10"),
            @ApiImplicitParam(name = "labelValue", value = "标签值", dataType = "String", paramType = "query")
    })
    @GetMapping("/hot")
    public JsonResult hot(Long current, Long size, String labelValue) {
        return indexLabelService.hot(current, size, labelValue, getUserId());
    }

    @ApiOperation(value = "关注", notes = "关注的动态")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current", value = "页码", dataType = "long", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "size", value = "数量", dataType = "long", paramType = "query", defaultValue = "10"),
            @ApiImplicitParam(name = "followUserId", value = "关注人Id", dataType = "long", paramType = "query")
    })
    @RequireUser
    @GetMapping("/follow")
    public JsonResult follow(Long current, Long size, Long followUserId) {
        return indexLabelService.follow(current, size, followUserId, getUserId());
    }

    @ApiOperation(value = "附近", notes = "我附近的动态")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current", value = "页码", dataType = "long", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "size", value = "数量", dataType = "long", paramType = "query", defaultValue = "10"),
            @ApiImplicitParam(name = "lng", value = "经度", required = true, dataType = "double", paramType = "query"),
            @ApiImplicitParam(name = "lat", value = "纬度", required = true, dataType = "double", paramType = "query"),
            @ApiImplicitParam(name = "distance", value = "距离（米）", dataType = "int", paramType = "query", defaultValue = "100000")
    })
    @GetMapping("/nearby")
    public JsonResult nearby(Long current, Long size, BigDecimal lng, BigDecimal lat, Integer distance) {
        if (null == lng || null == lat) {
            return JsonResult.failure(ErrorCode.BAD_REQUEST);
        }
        return indexLabelService.nearby(current, size, lng, lat, distance, getUserId());
    }

}
