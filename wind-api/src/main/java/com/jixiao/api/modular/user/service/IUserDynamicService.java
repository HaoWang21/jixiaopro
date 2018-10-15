package com.jixiao.api.modular.user.service;

import com.jixiao.common.JsonResult;
import com.jixiao.user.entity.dto.UserDynamicContentDTO;
import com.jixiao.user.entity.dto.UserDynamicContentImageDTO;
import com.jixiao.user.entity.dto.UserDynamicContentVideoDTO;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author jiang
 * @since 2018-09-28
 */
public interface IUserDynamicService {

    /**
     * 添加文字动态
     *
     * @param dto    文字信息
     * @param userId 用户Id
     * @return json
     */
    JsonResult save(UserDynamicContentDTO dto, Long userId);

    /**
     * 添加文字图片动态
     *
     * @param dto    文字图片信息
     * @param userId 用户Id
     * @return json
     */
    JsonResult save(UserDynamicContentImageDTO dto, Long userId);

    /**
     * 添加文字视频动态
     *
     * @param dto    文字视频
     * @param userId 用户Id
     * @return json
     */
    JsonResult save(UserDynamicContentVideoDTO dto, Long userId);

    /**
     * 删除
     *
     * @param id     唯一Id
     * @param userId 用户Id
     * @return json
     */
    JsonResult remove(Long id, Long userId);

    /**
     * 详情
     *
     * @param id 动态Id
     * @param userId 用户Id
     * @return json
     */
    JsonResult details(Long id, Long userId);

}
