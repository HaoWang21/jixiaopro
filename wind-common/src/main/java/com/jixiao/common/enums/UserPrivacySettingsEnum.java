package com.jixiao.common.enums;

import com.jixiao.common.interfaces.IEnum;
import com.jixiao.common.util.EnumUtil;

/**
 * <p>
 * 隐私设置类型枚举
 * </p>
 *
 * @author jiang
 * @since 2018-10-01
 */
public enum UserPrivacySettingsEnum implements IEnum {

    /**
     * 所有人
     */
    ALL("ALL"),
    /**
     * 我关注的人
     */
    FOLLOW("FOLLOW"),
    /**
     * 我的粉丝
     */
    FANS("FANS"),
    /**
     * 未知
     */
    UNKNOWN("UNKNOWN");
    /**
     * 主键
     */
    private final String id;

    UserPrivacySettingsEnum(String id) {
        this.id = id;
    }

    @Override
    public Object getValue() {
        return id;
    }

    /**
     * 根据主键获取值
     * @param id 主键
     * @return enum
     */
    public static UserPrivacySettingsEnum getKey(String id) {
        UserPrivacySettingsEnum userPrivacySettingsEnum = EnumUtil.getById(id, UserPrivacySettingsEnum.class);
        return null == userPrivacySettingsEnum ? UNKNOWN : userPrivacySettingsEnum;
    }
}
