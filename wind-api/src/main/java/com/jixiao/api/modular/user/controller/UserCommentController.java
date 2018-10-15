package com.jixiao.api.modular.user.controller;

import com.jixiao.api.core.annotation.RequireUser;
import com.jixiao.api.modular.user.service.IUserCommentService;
import com.jixiao.common.JsonResult;
import com.jixiao.common.base.BaseController;
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
@Api(tags = "用户评论", description = "UserCommentController")
@RestController
@RequestMapping("/userComment")
public class UserCommentController extends BaseController {

    @Autowired
    private IUserCommentService userCommentService;

    @ApiOperation(value = "我要评论or回复评论", notes = "我要评论")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userDynamicId", value = "动态Id", required = true, dataType = "long", paramType = "query"),
            @ApiImplicitParam(name = "parentId", value = "回复评论Id", dataType = "long", paramType = "query"),
            @ApiImplicitParam(name = "content", value = "舆论", required = true, dataType = "String", paramType = "query")
    })
    @RequireUser
    @PostMapping
    public JsonResult save(Long userDynamicId, Long parentId, String content) {
        return userCommentService.save(userDynamicId, parentId, content, getUserId());
    }

    @ApiOperation(value = "删除评论", notes = "我要删除评论")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "评论Id", required = true, dataType = "long", paramType = "query"),
            @ApiImplicitParam(name = "userDynamicId", value = "动态Id", required = true, dataType = "long", paramType = "query")
    })
    @RequireUser
    @DeleteMapping
    public JsonResult remove(Long id, Long userDynamicId) {
        return userCommentService.remove(id, userDynamicId, getUserId());
    }

    @ApiOperation(value = "查询动态的评论", notes = "这个动态有什么动态")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userDynamicId", value = "动态Id", required = true, dataType = "long", paramType = "query")
    })
    @GetMapping
    public JsonResult listByUserDynamicId(Long userDynamicId) {
        return JsonResult.success(userCommentService.listByUserDynamicId(userDynamicId));
    }

}
