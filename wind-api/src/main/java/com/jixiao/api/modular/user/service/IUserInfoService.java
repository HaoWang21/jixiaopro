package com.jixiao.api.modular.user.service;

import com.jixiao.common.JsonResult;
import com.jixiao.user.entity.dto.UserInfoUpdateDTO;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author jiang
 * @since 2018-09-29
 */
public interface IUserInfoService {

    /**
     * 修改用户信息-通用
     * @param dto 数据传输对象
     * @param userId 用户Id
     * @return json
     */
    JsonResult update(UserInfoUpdateDTO dto, Long userId);

    /**
     * 修改用户信息-上传通用
     * @param file 文件
     * @param type 类型：0头像 1背景图
     * @param userId 用户Id
     * @return json
     */
    JsonResult updateImage(MultipartFile file, Integer type, Long userId);
}
