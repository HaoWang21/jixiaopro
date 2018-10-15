package com.jixiao.common;

/**
 * <p>
 * 提示信息
 * </p>
 *
 * @author jiang
 * @since 2017-12-08
 */
public enum ErrorCode {

    /**
     * 成功
     */
    OK(200, "OK"),
    /**
     * 多种选择
     */
    MULTIPLE_CHOICES(300, "Multiple Choices"),
    /**
     * 错误的请求
     */
    BAD_REQUEST(400, "Bad Request"),
    /**
     * 未经授权的
     */
    UNAUTHORIZED(401, "Unauthorized"),
    /**
     * 被禁止的
     */
    FORBIDDEN(403, "Forbidden"),
    /**
     * 没有找到
     */
    NOT_FOUND(404, "Not Found"),
    /**
     * 方法不允许
     */
    METHOD_NOT_ALLOWED(405, "Method Not Allowed"),
    /**
     * 内部服务器错误
     */
    INTERNAL_SERVER_ERROR(500, "Internal Server Error");


    private Integer code;
    private String msg;

    ErrorCode(Integer code, String msg) {
        this.setCode(code);
        this.setMsg(msg);
    }

    public static ErrorCode fromCode(Integer code) {
        ErrorCode[] ecs = ErrorCode.values();
        for (ErrorCode ec : ecs) {
            if (ec.getCode().equals(code)) {
                return ec;
            }
        }
        return null;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ErrorCode{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
