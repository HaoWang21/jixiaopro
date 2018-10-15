package com.jixiao.api.modular.tool.service;

import com.jixiao.common.JsonResult;

/**
 * @author jiang
 * @since 2018-09-28
 */
public interface IToolShortMessageService {

    /**
     * 添加
     *
     * @param mobile 手机号
     * @param type 类型：0注册 1登录 2修改密码 3找回密码
     * @return json
     */
    JsonResult save(String mobile, Integer type);
}
