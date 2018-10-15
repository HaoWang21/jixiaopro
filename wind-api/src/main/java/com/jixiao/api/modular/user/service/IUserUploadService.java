package com.jixiao.api.modular.user.service;

import com.jixiao.common.JsonResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author jiang
 * @since 2018-09-28
 */
public interface IUserUploadService {

    /**
     * 发表动态上传的资源
     *
     * @param file   文件
     * @param userId 用户Id
     * @return json
     */
    JsonResult upload(MultipartFile file, Long userId);
}
