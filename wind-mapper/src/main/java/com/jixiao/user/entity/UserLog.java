package com.jixiao.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 用户操作日志
 * </p>
 *
 * @author jiang
 * @since 2018-10-08
 */
public class UserLog implements Serializable {

    private static final long serialVersionUID = 1L;

	@TableId(value = "id", type = IdType.AUTO)
	private Long id;
    /**
     * 用户id
     */
	private Long userId;
    /**
     * 路径
     */
	private String requestUri;
    /**
     * 访问方式
     */
	private String httpMethod;
    /**
     * 操作
     */
	private String operation;
    /**
     * 入参
     */
	private String param;
    /**
     * 设备类型
     */
	private String deviceType;
    /**
     * 访问IP
     */
	private String createIp;
    /**
     * 响应状态
     */
	private Integer responseStatus;
    /**
     * 异常信息
     */
	private String errorMessage;
    /**
     * 执行耗费的时间(ms)
     */
	private Long executionTime;
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


	public UserLog() {

	}

	private UserLog(Builder builder) {
		this.id = builder.id;
		this.userId = builder.userId;
		this.requestUri = builder.requestUri;
		this.httpMethod = builder.httpMethod;
		this.operation = builder.operation;
		this.param = builder.param;
		this.deviceType = builder.deviceType;
		this.createIp = builder.createIp;
		this.responseStatus = builder.responseStatus;
		this.errorMessage = builder.errorMessage;
		this.executionTime = builder.executionTime;
		this.gmtCreate = builder.gmtCreate;
		this.gmtModified = builder.gmtModified;
		this.delFlag = builder.delFlag;
	}


	public static class Builder {

        private Long id;
        private Long userId;
        private String requestUri;
        private String httpMethod;
        private String operation;
        private String param;
        private String deviceType;
        private String createIp;
        private Integer responseStatus;
        private String errorMessage;
        private Long executionTime;
        private Date gmtCreate;
        private Date gmtModified;
        private Boolean delFlag;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }
        public Builder userId(Long userId) {
            this.userId = userId;
            return this;
        }
        public Builder requestUri(String requestUri) {
            this.requestUri = requestUri;
            return this;
        }
        public Builder httpMethod(String httpMethod) {
            this.httpMethod = httpMethod;
            return this;
        }
        public Builder operation(String operation) {
            this.operation = operation;
            return this;
        }
        public Builder param(String param) {
            this.param = param;
            return this;
        }
        public Builder deviceType(String deviceType) {
            this.deviceType = deviceType;
            return this;
        }
        public Builder createIp(String createIp) {
            this.createIp = createIp;
            return this;
        }
        public Builder responseStatus(Integer responseStatus) {
            this.responseStatus = responseStatus;
            return this;
        }
        public Builder errorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
            return this;
        }
        public Builder executionTime(Long executionTime) {
            this.executionTime = executionTime;
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

        public UserLog build() {
			return new UserLog(this);
		}
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getRequestUri() {
		return requestUri;
	}

	public void setRequestUri(String requestUri) {
		this.requestUri = requestUri;
	}

	public String getHttpMethod() {
		return httpMethod;
	}

	public void setHttpMethod(String httpMethod) {
		this.httpMethod = httpMethod;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getCreateIp() {
		return createIp;
	}

	public void setCreateIp(String createIp) {
		this.createIp = createIp;
	}

	public Integer getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(Integer responseStatus) {
		this.responseStatus = responseStatus;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Long getExecutionTime() {
		return executionTime;
	}

	public void setExecutionTime(Long executionTime) {
		this.executionTime = executionTime;
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
        return "UserLog{" +
                "id=" + id +
                ", userId=" + userId +
                ", requestUri=" + requestUri +
                ", httpMethod=" + httpMethod +
                ", operation=" + operation +
                ", param=" + param +
                ", deviceType=" + deviceType +
                ", createIp=" + createIp +
                ", responseStatus=" + responseStatus +
                ", errorMessage=" + errorMessage +
                ", executionTime=" + executionTime +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", delFlag=" + delFlag +
                "}";
	}
}
