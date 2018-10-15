package com.jixiao.api.core.exception;

import com.jixiao.common.ErrorCode;

/**
 * <p>
 * 自定义异常
 * </p>
 *
 * @author jiang
 * @since 2018-08-31
 */
public class DiyException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private Integer code;
    private String msg;

    public DiyException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public DiyException(ErrorCode errorCode) {
        super(errorCode.getMsg());
        this.code = errorCode.getCode();
        this.msg = errorCode.getMsg();
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
}
