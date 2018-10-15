package com.jixiao.api.modular.user.controller;

import com.jixiao.api.core.annotation.RequireUser;
import com.jixiao.api.modular.user.service.IUserCustomService;
import com.jixiao.common.ErrorCode;
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
@Api(tags = "用户点赞/收藏", description = "UserCustomController")
@RestController
@RequireUser
@RequestMapping("/userCustom")
public class UserCustomController extends BaseController {

    @Autowired
    private IUserCustomService userCustomService;

    @ApiOperation(value = "点赞/收藏(user)", notes = "请求第一点赞请求第二次取消点赞")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userDynamicId", value = "动态Id", required = true, dataType = "long", paramType = "query"),
            @ApiImplicitParam(name = "type", value = "类型：0点赞 1收藏", required = true, dataType = "int", paramType = "query")
    })
    @PostMapping
    public JsonResult saveOrRemove(Long userDynamicId, Integer type) {
        switch (type) {
            case 0:
            case 1:
                break;
            default:
                return JsonResult.failure(ErrorCode.BAD_REQUEST);
        }
        return userCustomService.saveOrRemove(userDynamicId, type, getUserId());
    }

}
