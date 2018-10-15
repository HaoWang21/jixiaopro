package com.jixiao.tool.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 短信
 * </p>
 *
 * @author jiang
 * @since 2018-09-28
 */
public class ToolShortMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 验证码
     */
    private String code;
    /**
     * 类型：0注册 1登录 2修改密码 3找回密码
     */
    private Integer type;
    /**
     * 发送IP
     */
    private String sendIp;
    /**
     * 第三方错误信息
     */
    private String errorMessage;
    /**
     * 状态：0未使用 1已使用
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Date gmtCreate;
    /**
     * 更新时间
     */
    private Date gmtModified;
    /**
     * 是否删除: 1是 0否
     */
    private Boolean delFlag;


    public ToolShortMessage() {

    }

    private ToolShortMessage(Builder builder) {
        this.id = builder.id;
        this.mobile = builder.mobile;
        this.code = builder.code;
        this.type = builder.type;
        this.sendIp = builder.sendIp;
        this.errorMessage = builder.errorMessage;
        this.status = builder.status;
        this.gmtCreate = builder.gmtCreate;
        this.gmtModified = builder.gmtModified;
        this.delFlag = builder.delFlag;
    }


    public static class Builder {

        private Integer id;
        private String mobile;
        private String code;
        private Integer type;
        private String sendIp;
        private String errorMessage;
        private Integer status;
        private Date gmtCreate;
        private Date gmtModified;
        private Boolean delFlag;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder mobile(String mobile) {
            this.mobile = mobile;
            return this;
        }

        public Builder code(String code) {
            this.code = code;
            return this;
        }

        public Builder type(Integer type) {
            this.type = type;
            return this;
        }

        public Builder sendIp(String sendIp) {
            this.sendIp = sendIp;
            return this;
        }

        public Builder errorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
            return this;
        }

        public Builder status(Integer status) {
            this.status = status;
            return this;
        }

        public Builder gmtCreate(Date gmtCreate) {
            this.gmtCreate = gmtCreate;
            return this;
        }

        public Builder gmtModified(Date gmtModified) {
            this.gmtModified = gmtModified;
            return this;
        }

        public Builder delFlag(Boolean delFlag) {
            this.delFlag = delFlag;
            return this;
        }

        public ToolShortMessage build() {
            return new ToolShortMessage(this);
        }
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getSendIp() {
        return sendIp;
    }

    public void setSendIp(String sendIp) {
        this.sendIp = sendIp;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Boolean getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public String toString() {
        return "ToolShortMessage{" +
                "id=" + id +
                ", mobile=" + mobile +
                ", code=" + code +
                ", type=" + type +
                ", sendIp=" + sendIp +
                ", errorMessage=" + errorMessage +
                ", status=" + status +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", delFlag=" + delFlag +
                "}";
    }
}
