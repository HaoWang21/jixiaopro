package com.jixiao.api.modular.user.controller;

import com.jixiao.api.core.annotation.RequireUser;
import com.jixiao.api.modular.user.service.IUserInfoService;
import com.jixiao.api.modular.user.service.IUserService;
import com.jixiao.common.ErrorCode;
import com.jixiao.common.JsonResult;
import com.jixiao.common.base.BaseController;
import com.jixiao.user.entity.dto.UserInfoUpdateDTO;
import com.jixiao.user.entity.vo.UserInfoVO;
import io.swagger.annotations.*;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author jiang
 * @since 2018-09-29
 */
@Api(tags = "用户信息", description = "UserInfoController")
@RestController
@RequireUser
@RequestMapping("/userInfo")
public class UserInfoController extends BaseController {

    @Autowired
    private IUserInfoService userInfoService;
    @Autowired
    private IUserService userService;

    @ApiOperation(value = "详情(user)", notes = "基本信息")
    @GetMapping
    public JsonResult<UserInfoVO> details() {
        return JsonResult.success(userService.userInfo(getUserId()));
    }

    @ApiOperation(value = "修改信息-通用(user)", notes = "修改基本信息")
    @PostMapping("/update")
    public JsonResult update(UserInfoUpdateDTO dto) {
        return userInfoService.update(dto, getUserId());
    }

    @ApiOperation(value = "修改信息-上传通用(user)", notes = "修改[ 头像/背景图 ]")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", value = "类型：0头像 1背景图", required = true, dataType = "int", paramType = "query")
    })
    @PostMapping("/updateByUpload")
    public JsonResult updateImage(@ApiParam(hidden = true) @RequestParam("file") MultipartFile file, Integer type) {
        boolean check = ServletFileUpload.isMultipartContent(request);
        if (!check) {
            return JsonResult.failure(ErrorCode.BAD_REQUEST);
        }
        return userInfoService.updateImage(file, type, getUserId());
    }
}
