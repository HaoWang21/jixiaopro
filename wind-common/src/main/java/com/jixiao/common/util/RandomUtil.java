package com.jixiao.common.util;

import java.util.Random;

/**
 * <p>
 * 随机字符工具
 * </p>
 *
 * @author jiang
 * @since 2018-08-30
 */
public class RandomUtil {

    /**
     * 所有大小写字母和数字
     */
    private static final String ALL_CHAR = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    /**
     * 所有大小写字母
     */
    private static final String LETTER_CHAR = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    /**
     * 所有数字
     */
    private static final String NUMBER_CHAR = "0123456789";

    /**
     * 返回一个定长的随机纯数字字符串(只包含数字)
     * @param length 随机字符串长度
     * @return 随机字符串
     */
    public static String generateDigitalString(int length) {
        StringBuilder buffer = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            buffer.append(NUMBER_CHAR.charAt(random.nextInt(NUMBER_CHAR.length())));
        }
        return buffer.toString();
    }

    /**
     * 返回一个定长的随机字符串(只包含大小写字母、数字)
     * @param length 随机字符串长度
     * @return 随机字符串
     */
    public static String generateString(int length) {
        StringBuilder buffer = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            buffer.append(ALL_CHAR.charAt(random.nextInt(ALL_CHAR.length())));
        }
        return buffer.toString();
    }

    /**
     * 返回一个定长的随机纯字母字符串(只包含大小写字母)
     * @param length 随机字符串长度
     * @return 随机字符串
     */
    public static String generateMixString(int length) {
        StringBuilder buffer = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            buffer.append(LETTER_CHAR.charAt(random.nextInt(LETTER_CHAR.length())));
        }
        return buffer.toString();
    }

    /**
     * 返回一个定长的随机纯大写字母字符串(只包含大小写字母)
     * @param length 随机字符串长度
     * @return 随机字符串
     */
    public static String generateLowerString(int length) {
        return generateMixString(length).toLowerCase();
    }

    /**
     * 返回一个定长的随机纯小写字母字符串(只包含大小写字母)
     * @param length 随机字符串长度
     * @return 随机字符串
     */
    public static String generateUpperString(int length) {
        return generateMixString(length).toUpperCase();
    }
}
