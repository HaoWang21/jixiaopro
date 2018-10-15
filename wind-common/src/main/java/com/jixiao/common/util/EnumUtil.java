package com.jixiao.common.util;

import com.jixiao.common.interfaces.IEnum;

/**
 * <p>
 * 枚举工具
 * </p>
 *
 * @author jiang
 * @since 2018-10-01
 */
public class EnumUtil {

    public static <T extends IEnum> T getById(Object id, Class<? extends IEnum> enumClass) {
        return (T) getById(id, enumClass.getEnumConstants());
    }

    private static <T extends IEnum> T getById(Object id, T[] values) {
        if (null == id) {
            return null;
        }
        if (id instanceof String && StringUtil.isBlank((String) id)) {
            return null;
        }
        for (T item : values) {
            if (id.equals(item.getValue())) {
                return item;
            }
        }
        return null;
    }

}
