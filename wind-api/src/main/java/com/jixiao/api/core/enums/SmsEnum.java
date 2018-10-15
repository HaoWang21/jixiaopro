package com.jixiao.api.core.enums;

/**
 * <p>
 * 短信消息模板
 * </p>
 *
 * @author jiang
 * @since 2018-08-30
 */
public enum SmsEnum {

    /**
     * 用户注册验证码
     */
    REGISTER("SMS_143675200"),
    /**
     * 登录确认验证码
     */
    LOGIN("SMS_143675202"),
    /**
     * 修改密码验证码
     */
    CHANGE_PASSWORD("SMS_143675199"),
    /**
     * 忘记密码验证码
     */
    FORGET_PASSWORD("SMS_143675203");

    private String code;

    SmsEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
