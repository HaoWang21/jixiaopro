package com.jixiao.common.util;

import java.util.Random;

/**
 * <p>
 * 邀请码工具
 * </p>
 *
 * @author jiang
 * @since 2018-08-30
 */
public class RefereeCodeUtil {

    /**
     * 自定义进制(0,1没有加入,容易与o,l混淆)
     */
    private static final char[] R = new char[]{'q', 'w', 'e', '8', 'a', 's', '2', 'd', 'z', 'x', '9', 'c', '7', 'p',
            '5', 'i', 'k', '3', 'm', 'j', 'u', 'f', 'r', '4', 'v', 'y', 'l', 't', 'n', '6', 'b', 'g', 'h'};

    /**
     * (不能与自定义进制有重复)
     */
    private static final char B = 'o';

    /**
     * 进制长度
     */
    private static final int LENGTH = R.length;

    /**
     * 序列最小长度
     */
    private static final int SIZE = 8;

    /**
     * 根据ID生成六位随机码
     *
     * @param id ID
     * @return 随机码
     */
    public static String toSerialCode(Integer id) {
        char[] buf = new char[32];
        int charPos = 32;

        while ((id / LENGTH) > 0) {
            int ind = (id % LENGTH);
            buf[--charPos] = R[ind];
            id /= LENGTH;
        }
        buf[--charPos] = R[id % LENGTH];
        String str = new String(buf, charPos, (32 - charPos));
        // 不够长度的自动随机补全
        if (str.length() < SIZE) {
            StringBuilder sb = new StringBuilder();
            sb.append(B);
            Random rnd = new Random();
            for (int i = 1; i < SIZE - str.length(); i++) {
                sb.append(R[rnd.nextInt(LENGTH)]);
            }
            str += sb.toString();
        }
        return str;
    }
}
