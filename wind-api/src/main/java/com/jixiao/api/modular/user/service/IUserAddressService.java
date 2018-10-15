package com.jixiao.api.modular.user.service;

import com.jixiao.common.JsonResult;
import com.jixiao.user.entity.dto.UserAddressUpdateDTO;
import com.jixiao.user.entity.vo.UserAddressVO;

import java.util.List;

/**
 * @author jiang
 * @since 2018-10-01
 */
public interface IUserAddressService {

    /**
     * 列表
     *
     * @param userId 用户Id
     * @return json
     */
    JsonResult<List<UserAddressVO>> list(Long userId);

    /**
     * 添加
     *
     * @param dto 数据传输对象
     * @param userId 用户Id
     * @return json
     */
    JsonResult save(UserAddressUpdateDTO dto, Long userId);

    /**
     * 删除
     *
     * @param id 唯一Id
     * @param userId 用户Id
     * @return json
     */
    JsonResult remove(Long id, Long userId);

    /**
     * 修改
     *
     * @param id 唯一Id
     * @param dto 数据传输对象
     * @param userId 用户Id
     * @return json
     */
    JsonResult update(Long id, UserAddressUpdateDTO dto, Long userId);

    /**
     * 详情
     *
     * @param id 唯一Id
     * @param userId 用户Id
     * @return json
     */
    JsonResult details(Long id, Long userId);
}
