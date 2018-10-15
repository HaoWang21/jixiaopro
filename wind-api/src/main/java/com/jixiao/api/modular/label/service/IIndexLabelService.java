package com.jixiao.api.modular.label.service;

import com.jixiao.common.JsonResult;

import java.math.BigDecimal;

/**
 * @author jiang
 * @since 2018-10-09
 */
public interface IIndexLabelService {

    /**
     * 热门
     *
     * @param current 页码
     * @param size 条数
     * @param labelValue 标签值
     * @param userId 用户Id
     * @return json
     */
    JsonResult hot(Long current, Long size, String labelValue, Long userId);

    /**
     * 关注
     *
     * @param current 页码
     * @param size 条数
     * @param followUserId 关注人Id
     * @param userId 用户Id
     * @return json
     */
    JsonResult follow(Long current, Long size, Long followUserId, Long userId);

    /**
     * 附近
     *
     * @param current 页码
     * @param size 条数
     * @param lng 经度
     * @param lat 纬度
     * @param distance 距离（米）
     * @param userId 用户Id
     * @return json
     */
    JsonResult nearby(Long current, Long size, BigDecimal lng, BigDecimal lat, Integer distance, Long userId);
}
