package com.jixiao.common.util;

import java.security.MessageDigest;

/**
 * <p>
 * md5加密工具
 * </p>
 *
 * @author jiang
 * @since 2018-08-30
 */
public class Md5Util {

    /**
     * 加密
     * @param text 字符串
     * @return 密文
     */
    public static String md5(String text) {
        // 用于加密的字符
        char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        try {
            // 使用平台的默认字符集将此 String 编码为 byte序列，并将结果存储到一个新的 byte数组中
            byte[] input = text.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            md.update(input);
            // 获得密文
            byte[] digest = md.digest();

            // 把密文转换成十六进制的字符串形式
            int j = digest.length;
            char[] str = new char[j * 2];
            int k = 0;
            for (byte by : digest) {
                str[k++] = hexDigits[by >>> 4 & 0xf];
                str[k++] = hexDigits[by & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 验证输入的密码是否正确
     * @param password 密码
     * @param text 明文
     * @return boolean
     */
    public static boolean validatePassword(String password, String text) {
        if (StringUtil.isBlank(password) || StringUtil.isBlank(text)) {
            return true;
        }
        return !password.equals(Md5Util.md5(text));
    }
}
