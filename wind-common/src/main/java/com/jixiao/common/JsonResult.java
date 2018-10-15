package com.jixiao.common;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * <p>
 * 被访问时响应的数据结构
 * </p>
 *
 * @author jiang
 * @since 2017-12-08
 */
public class JsonResult<T> {

    @JSONField(ordinal = 1)
    private Integer code;
    @JSONField(ordinal = 2)
    private String msg;
    @JSONField(ordinal = 3)
    private T data;

    private JsonResult() {
        this.data = null;
    }

    private JsonResult(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.msg = errorCode.getMsg();
        this.data = null;
    }

    public static JsonResult success() {
        return new JsonResult(ErrorCode.OK);
    }

    @SuppressWarnings("unchecked")
    public static <T> JsonResult<T> success(T data) {
        return success()
                .setData(data);
    }

    public static JsonResult failure(ErrorCode errorCode) {
        return new JsonResult()
                .setCode(errorCode.getCode())
                .setMsg(errorCode.getMsg());
    }

    public static JsonResult failure(ErrorCode errorCode, String msg) {
        return new JsonResult()
                .setCode(errorCode.getCode())
                .setMsg(msg);
    }

    public static JsonResult failure(Integer code, String msg) {
        return new JsonResult()
                .setCode(code)
                .setMsg(msg);
    }

    public Integer getCode() {
        return code;
    }

    private JsonResult setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    private JsonResult setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return data;
    }

    private JsonResult setData(T data) {
        this.data = data;
        return this;
    }
}
