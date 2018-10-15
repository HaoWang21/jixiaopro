package com.jixiao.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 用户点赞/收藏
 * </p>
 *
 * @author jiang
 * @since 2018-10-10
 */
public class UserCustom implements Serializable {

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
     * 类型：0点赞 1收藏
     */
	private Integer type;
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


	public UserCustom() {

	}

	private UserCustom(Builder builder) {
		this.id = builder.id;
		this.userDynamicId = builder.userDynamicId;
		this.userId = builder.userId;
		this.type = builder.type;
		this.gmtCreate = builder.gmtCreate;
		this.gmtModified = builder.gmtModified;
		this.delFlag = builder.delFlag;
	}


	public static class Builder {

        private Long id;
        private Long userDynamicId;
        private Long userId;
        private Integer type;
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
        public Builder type(Integer type) {
            this.type = type;
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

        public UserCustom build() {
			return new UserCustom(this);
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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
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
        return "UserCustom{" +
                "id=" + id +
                ", userDynamicId=" + userDynamicId +
                ", userId=" + userId +
                ", type=" + type +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", delFlag=" + delFlag +
                "}";
	}
}
