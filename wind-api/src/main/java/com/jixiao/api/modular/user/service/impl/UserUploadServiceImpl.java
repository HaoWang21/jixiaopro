package com.jixiao.api.modular.user.service.impl;

import com.jixiao.api.core.util.OssUtil;
import com.jixiao.api.modular.user.service.IUserUploadService;
import com.jixiao.common.ErrorCode;
import com.jixiao.common.JsonResult;
import com.jixiao.user.entity.UserUpload;
import com.jixiao.user.mapper.IUserUploadMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

/**
 * @author jiang
 * @since 2018-09-28
 */
@Service
public class UserUploadServiceImpl implements IUserUploadService {

    @Autowired
    private IUserUploadMapper userUploadMapper;

    @Override
    public JsonResult upload(MultipartFile file, Long userId) {
        try {
            String originalFilename = file.getOriginalFilename();
            assert originalFilename != null;
            String suffix = originalFilename.substring(originalFilename.lastIndexOf(".")).toLowerCase();
            String url = OssUtil.upload("user/dynamic/" + userId + "/" + UUID.randomUUID().toString().replace("-", "") + suffix, file.getInputStream());

            UserUpload userUpload = new UserUpload.Builder()
                    .userId(userId)
                    .url(url)
                    .contentType(file.getContentType())
                    .size(String.valueOf(file.getSize()))
                    .build();

            userUploadMapper.insert(userUpload);

            return JsonResult.success(userUpload.getId());
        } catch (IOException e) {
            return JsonResult.failure(ErrorCode.INTERNAL_SERVER_ERROR);
        }
    }
}
