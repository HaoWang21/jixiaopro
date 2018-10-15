package com.jixiao.common.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
/**
 * <p>
 * Cookie工具
 * </p>
 *
 * @author jiang
 * @since 2018-09-28
 */
public class CookieUtil {

    /**
     * 设置 Cookie
     * @param response 响应对象
     * @param name 名称
     * @param value 值
     * @param maxAge 生存时间（单位秒）
     */
    public static void setCookie(HttpServletResponse response, String name, String value, int maxAge) {
        setCookie(response, name, null, value, "/", maxAge);
    }

    /**
     * 设置 Cookie
     * @param response 响应对象
     * @param name 名称
     * @param value 值
     * @param path 路径
     * @param maxAge 生存时间（单位秒）
     */
    public static void setCookie(HttpServletResponse response, String name, String pattern, String value, String path, int maxAge) {
        Cookie cookie = new Cookie(name, null);
        if (StringUtil.isNotBlank(pattern)) {
            cookie.setDomain(pattern);
        }
        cookie.setPath(path);
        cookie.setMaxAge(maxAge);
        try {
            cookie.setValue(URLEncoder.encode(value, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.addCookie(cookie);
    }

    /**
     * 获得指定Cookie的值
     * @param request 请求对象
     * @param name 名称
     * @return 值
     */
    public static String getCookie(HttpServletRequest request, String name) {
        return getCookie(request, null, name, false);
    }

    /**
     * 删除指定Cookie的值
     * @param request 请求对象
     * @param response 响应对象
     * @param name 名称
     */
    public static void removeCookie(HttpServletRequest request, HttpServletResponse response, String name) {
        getCookie(request, response, name, true);
    }

    /**
     * 获得指定Cookie的值
     * @param request 请求对象
     * @param response 响应对象
     * @param name 名字
     * @param isRemove 是否移除
     * @return 值
     */
    private static String getCookie(HttpServletRequest request, HttpServletResponse response, String name, boolean isRemove) {
        String value = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(name)) {
                    try {
                        value = URLDecoder.decode(cookie.getValue(), "utf-8");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    if (isRemove) {
                        cookie.setMaxAge(0);
                        response.addCookie(cookie);
                    }
                }
            }
        }
        return value;
    }
}
