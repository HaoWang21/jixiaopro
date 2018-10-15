package com.jixiao.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 用户上传的资源
 * </p>
 *
 * @author jiang
 * @since 2018-10-10
 */
public class UserUpload implements Serializable {

    private static final long serialVersionUID = 1L;

	@TableId(value = "id", type = IdType.AUTO)
	private Long id;
    /**
     * 用户动态Id
     */
	private Long userDynamicId;
    /**
     * 用户Id
     */
	private Long userId;
    /**
     * 链接
     */
	private String url;
    /**
     * 类型
     */
	private String contentType;
    /**
     * 大小
     */
	private String size;
    /**
     * 状态：0正常 1违规
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


	public UserUpload() {

	}

	private UserUpload(Builder builder) {
		this.id = builder.id;
		this.userDynamicId = builder.userDynamicId;
		this.userId = builder.userId;
		this.url = builder.url;
		this.contentType = builder.contentType;
		this.size = builder.size;
		this.status = builder.status;
		this.gmtCreate = builder.gmtCreate;
		this.gmtModified = builder.gmtModified;
		this.delFlag = builder.delFlag;
	}


	public static class Builder {

        private Long id;
        private Long userDynamicId;
        private Long userId;
        private String url;
        private String contentType;
        private String size;
        private Integer status;
        private Date gmtCreate;
        private Date gmtModified;
        private Boolean delFlag;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }
        public Builder userDynamicId(Long userDynamicId) {
            this.userDynamicId = userDynamicId;
            return this;
        }
        public Builder userId(Long userId) {
            this.userId = userId;
            return this;
        }
        public Builder url(String url) {
            this.url = url;
            return this;
        }
        public Builder contentType(String contentType) {
            this.contentType = contentType;
            return this;
        }
        public Builder size(String size) {
            this.size = size;
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

        public UserUpload build() {
			return new UserUpload(this);
		}
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserDynamicId() {
		return userDynamicId;
	}

	public void setUserDynamicId(Long userDynamicId) {
		this.userDynamicId = userDynamicId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
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
        return "UserUpload{" +
                "id=" + id +
                ", userDynamicId=" + userDynamicId +
                ", userId=" + userId +
                ", url=" + url +
                ", contentType=" + contentType +
                ", size=" + size +
                ", status=" + status +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", delFlag=" + delFlag +
                "}";
	}
}
