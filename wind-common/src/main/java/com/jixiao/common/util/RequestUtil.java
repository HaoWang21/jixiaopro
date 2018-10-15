package com.jixiao.common.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * <p>
 * 入参工具
 * </p>
 *
 * @author jiang
 * @since 2018-06-28
 */
public class RequestUtil {

    /**
     * 获取客户端实际IP地址
     */
    public static String getRemoteAddr() {
        HttpServletRequest request = getRequest();
        String ip = getRequest().getHeader("x-forwarded-for");
        if (StringUtil.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtil.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtil.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (StringUtil.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (StringUtil.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }
        if (StringUtil.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip != null && ip.indexOf(",") > 0) {
            // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
            String[] ips = ip.split(",");
            for (String ip2 : ips) {
                if (!"unknown".equalsIgnoreCase(ip2)) {
                    ip = ip2;
                    break;
                }
            }
        }
        if ("127.0.0.1".equals(ip) || "0:0:0:0:0:0:0:1".equals(ip)) {
            InetAddress inetAddress = null;
            try { // 根据网卡取本机配置的IP
                inetAddress = InetAddress.getLocalHost();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
            if (null != inetAddress) {
                ip = inetAddress.getHostAddress();
            }
        }
        return ip;
    }

    /**
     * 获取客户端设备类型
     */
    public static String getDeviceType() {
        String userAgent = getRequest().getHeader("user-agent");
        if (userAgent.contains("iPhone") || userAgent.contains("iPod") || userAgent.contains("iPad")) {
            return "IOS";
        } else if (userAgent.contains("Android")) {
            return "ANDROID";
        }
        return "PC";
    }

    /**
     * 获取Request
     */
    public static HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }
}
