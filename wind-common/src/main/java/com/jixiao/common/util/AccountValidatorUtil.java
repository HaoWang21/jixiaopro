package com.jixiao.common.util;

import java.util.regex.Pattern;

/**
 * <p>
 * 账户相关属性验证工具
 * </p>
 *
 * @author jiang
 * @since 2018-09-06
 */
public class AccountValidatorUtil {

    /**
     * 正则表达式：验证密码
     */
    private static final String REGEX_PASSWORD = "^[a-zA-Z0-9]{6,20}$";

    /**
     * 正则表达式：验证手机号
     */
    private static final String REGEX_MOBILE = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";

    /**
     * 正则表达式：验证邮箱
     */
    private static final String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

    /**
     * 正则表达式：验证汉字
     */
    private static final String REGEX_CHINESE = "^[\u4e00-\u9fa5],{0,}$";

    /**
     * 正则表达式：验证身份证
     */
    private static final String REGEX_ID_CARD = "(^\\d{18}$)|(^\\d{15}$)";

    /**
     * 校验密码
     * @param password 密码
     * @return 校验通过返回true，否则返回false
     */
    public static Boolean validatePassword(String password) {
        return Pattern.matches(REGEX_PASSWORD, password);
    }

    /**
     * 校验手机号
     * @param mobile 手机号
     * @return 校验通过返回true，否则返回false
     */
    public static Boolean validateMobile(String mobile) {
        return Pattern.matches(REGEX_MOBILE, mobile);
    }

    /**
     * 校验邮箱
     * @param email 邮箱
     * @return 校验通过返回true，否则返回false
     */
    public static Boolean validateEmail(String email) {
        return Pattern.matches(REGEX_EMAIL, email);
    }

    /**
     * 校验汉字
     * @param chinese 汉字
     * @return 校验通过返回true，否则返回false
     */
    public static Boolean validateChinese(String chinese) {
        return Pattern.matches(REGEX_CHINESE, chinese);
    }

    /**
     * 校验身份证
     * @param idCard 身份证
     * @return 校验通过返回true，否则返回false
     */
    public static Boolean validateIDCard(String idCard) {
        return Pattern.matches(REGEX_ID_CARD, idCard);
    }
}
