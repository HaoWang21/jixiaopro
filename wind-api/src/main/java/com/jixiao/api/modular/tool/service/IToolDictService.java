package com.jixiao.api.modular.tool.service;

import com.alibaba.fastjson.JSONObject;
import com.jixiao.common.JsonResult;

/**
 * @author jiang
 * @since 2018-09-28
 */
public interface IToolDictService {

    /**
     * 系统默认属性
     *
     * @return json
     */
    JSONObject selectDefaultConfig();

    /**
     * 根据key 获取系统默认属性
     *
     * @param key 主键
     * @param clazz 类型
     * @param <T> 类
     * @return t
     */
    <T> T selectDefaultConfigByKey(String key, Class<T> clazz);

    /**
     * 列表
     *
     * @param labelKey 主鍵
     * @return json
     */
    JsonResult list(String labelKey);
}
