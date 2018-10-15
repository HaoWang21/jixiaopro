package com.jixiao.api.modular.user.service;

import com.jixiao.common.JsonResult;
import com.jixiao.user.entity.vo.UserInfoVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author jiang
 * @since 2018-09-28
 */
public interface IUserService {

    /**
     * 登录
     *
     * @param username 账号
     * @param password 密码
     * @param code 验证码
     * @param request 请求对象
     * @param response 响应对象
     * @return json
     */
    JsonResult login(String username, String password, String code, HttpServletRequest request, HttpServletResponse response);

    /**
     * 退出
     *
     * @param request 请求对象
     * @param response 响应对象
     * @return json
     */
    JsonResult logoff(HttpServletRequest request, HttpServletResponse response);

    /**
     * 注册
     *
     * @param username 账号
     * @param password 密码
     * @param code 验证码
     * @param refereeCode 邀请码
     * @param request 请求对象
     * @param response 响应对象
     * @return json
     */
    JsonResult register(String username,  String password, String code, String refereeCode,
                        HttpServletRequest request, HttpServletResponse response);

    /**
     * 修改密码
     *
     * @param originalPassword 旧密码
     * @param password 密码
     * @param userId 用户Id
     * @param request 请求对象
     * @param response 响应对象
     * @return json
     */
    JsonResult changePassword(String originalPassword, String password, Long userId, HttpServletRequest request, HttpServletResponse response);

    /**
     * 用户信息
     *
     * @param userId 用户Id
     * @return vo
     */
    UserInfoVO userInfo(Long userId);

}
