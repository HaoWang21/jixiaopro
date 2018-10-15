package com.jixiao.api.modular.user.controller;

import com.jixiao.api.core.annotation.RequireUser;
import com.jixiao.api.modular.user.service.IUserDynamicService;
import com.jixiao.common.JsonResult;
import com.jixiao.common.base.BaseController;
import com.jixiao.user.entity.dto.UserDynamicContentDTO;
import com.jixiao.user.entity.dto.UserDynamicContentImageDTO;
import com.jixiao.user.entity.dto.UserDynamicContentVideoDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author jiang
 * @since 2018-09-28
 */
@Api(tags = "用户动态", description = "UserDynamicController")
@RestController
@RequestMapping("/userDynamic")
public class UserDynamicController extends BaseController {

    @Autowired
    private IUserDynamicService userDynamicService;

    @ApiOperation(value = "发表文字动态(user)", notes = "我要发个文字动态")
    @RequireUser
    @PostMapping("/saveContent")
    public JsonResult saveContent(UserDynamicContentDTO dto) {
        return userDynamicService.save(dto, getUserId());
    }

    @ApiOperation(value = "发表文字图片动态(user)", notes = "我要发个文字图片动态")
    @RequireUser
    @PostMapping("/saveContentImages")
    public JsonResult saveContentImages(UserDynamicContentImageDTO dto) {
        return userDynamicService.save(dto, getUserId());
    }

    @ApiOperation(value = "发表文字视频动态(user)", notes = "我要发个文字视频动态")
    @RequireUser
    @PostMapping("/saveContentVideo")
    public JsonResult saveContentVideo(UserDynamicContentVideoDTO dto) {
        return userDynamicService.save(dto, getUserId());
    }

    @ApiOperation(value = "删除(user)", notes = "删除动态")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "动态Id", required = true, dataType = "long", paramType = "query")
    })
    @RequireUser
    @DeleteMapping
    public JsonResult remove(Long id) {
        return userDynamicService.remove(id, getUserId());
    }

    @ApiOperation(value = "详情(user)", notes = "查看详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "动态Id", required = true, dataType = "long", paramType = "query")
    })
    @GetMapping
    public JsonResult details(Long id) {
        return userDynamicService.details(id, getUserId());
    }
}
