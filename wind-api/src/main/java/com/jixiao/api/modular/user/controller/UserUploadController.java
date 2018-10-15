package com.jixiao.api.modular.user.controller;

import com.jixiao.api.core.annotation.RequireUser;
import com.jixiao.api.modular.user.service.IUserUploadService;
import com.jixiao.common.ErrorCode;
import com.jixiao.common.JsonResult;
import com.jixiao.common.base.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author jiang
 * @since 2018-09-28
 */
@Api(tags = "用户上传资源", description = "UserUploadController")
@RestController
@RequireUser
@RequestMapping("/userUpload")
public class UserUploadController extends BaseController {

    @Autowired
    private IUserUploadService userUploadService;

    @ApiOperation(value = "上传资源(user)", notes = "发动态上传照骗视频啊")
    @PostMapping("/upload")
    public JsonResult upload(@ApiParam(hidden = true) @RequestParam("file") MultipartFile file) {
        boolean check = ServletFileUpload.isMultipartContent(request);
        if (!check) {
            return JsonResult.failure(ErrorCode.BAD_REQUEST);
        }
        return userUploadService.upload(file, getUserId());
    }
}
