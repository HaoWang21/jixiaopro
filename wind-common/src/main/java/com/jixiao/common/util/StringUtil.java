package com.jixiao.common.util;

import java.nio.charset.StandardCharsets;

/**
 * <p>
 * 字符串工具
 * </p>
 *
 * @author jiang
 * @since 2018-07-02
 */
public class StringUtil {

    /**
     * 判断某字符串是否为空
     */
    public static boolean isEmpty(CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

    /**
     * 判断某字符串是否非空
     */
    public static boolean isNotEmpty(CharSequence cs) {
        return !isEmpty(cs);
    }

    /**
     * 判断某字符串是否为空或长度为0或由空白符构成
     */
    public static boolean isBlank(CharSequence cs) {
        int strLen;
        if(cs != null && (strLen = cs.length()) != 0) {
            for(int i = 0; i < strLen; ++i) {
                if(!Character.isWhitespace(cs.charAt(i))) {
                    return false;
                }
            }
            return true;
        } else {
            return true;
        }
    }

    /**
     * 判断某字符串是否不为空且长度不为0且不由空白符(whitespace) 构成
     */
    public static boolean isNotBlank(CharSequence cs) {
        return !isBlank(cs);
    }

    /**
     * 缩略字符串（不区分中英文字符）
     * @param str 目标字符串
     * @param length 截取长度
     * @return str
     */
    public static String abbr(String str, int length) {
        if (str.length() < length) {
            return str;
        }
        return str.substring(0, length) + "...";
    }

    /**
     * 加密
     *
     * (带表情字符处理)
     * @param content 字符串
     * @return str
     */
    public static String encodeBase64String(String content) {
        return org.apache.commons.codec.binary.Base64.encodeBase64String(content.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * 解密
     *
     * (带表情字符处理)
     * @param content 字符串
     * @return str
     */
    public static String decodeBase64(String content) {
        if (StringUtil.isBlank(content)) {
            return "";
        }
        return new String(org.apache.commons.codec.binary.Base64.decodeBase64(content), StandardCharsets.UTF_8);
    }
}
