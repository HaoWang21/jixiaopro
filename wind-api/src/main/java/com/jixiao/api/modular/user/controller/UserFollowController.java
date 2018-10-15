package com.jixiao.api.modular.user.controller;

import com.jixiao.api.core.annotation.RequireUser;
import com.jixiao.api.modular.user.service.IUserFollowService;
import com.jixiao.common.JsonResult;
import com.jixiao.common.base.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiang
 * @since 2018-09-28
 */
@Api(tags = "用户关注", description = "UserFollowController")
@RestController
@RequireUser
@RequestMapping("/userFollow")
public class UserFollowController extends BaseController {

    @Autowired
    private IUserFollowService userFollowService;

    @ApiOperation(value = "关注(user)", notes = "请求第一关注请求第二次取消关注")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "followUserId", value = "想关注的人Id", required = true, dataType = "long", paramType = "query")
    })
    @PostMapping
    public JsonResult saveOrRemove(Long followUserId) {
        return userFollowService.saveOrRemove(followUserId, getUserId());
    }

}
