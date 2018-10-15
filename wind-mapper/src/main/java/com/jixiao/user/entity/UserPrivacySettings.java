package com.jixiao.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 用户隐私设置
 * </p>
 *
 * @author jiang
 * @since 2018-10-08
 */
public class UserPrivacySettings implements Serializable {

    private static final long serialVersionUID = 1L;

	@TableId(value = "id", type = IdType.AUTO)
	private Long id;
    /**
     * 用户Id
     */
	private Long userId;
    /**
     * 那些人可以评论我的动态
     */
	private String comment;
    /**
     * 是否开启附近的人：1开启 0关闭
     */
	private Boolean location;
    /**
     * 我可以收到那些人的@提醒
     */
	private String ate;
    /**
     * 我可以收到那些人的私信
     */
	private String letter;
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


	public UserPrivacySettings() {

	}

	private UserPrivacySettings(Builder builder) {
		this.id = builder.id;
		this.userId = builder.userId;
		this.comment = builder.comment;
		this.location = builder.location;
		this.ate = builder.ate;
		this.letter = builder.letter;
		this.gmtCreate = builder.gmtCreate;
		this.gmtModified = builder.gmtModified;
		this.delFlag = builder.delFlag;
	}


	public static class Builder {

        private Long id;
        private Long userId;
        private String comment;
        private Boolean location;
        private String ate;
        private String letter;
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
        public Builder comment(String comment) {
            this.comment = comment;
            return this;
        }
        public Builder location(Boolean location) {
            this.location = location;
            return this;
        }
        public Builder ate(String ate) {
            this.ate = ate;
            return this;
        }
        public Builder letter(String letter) {
            this.letter = letter;
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

        public UserPrivacySettings build() {
			return new UserPrivacySettings(this);
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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Boolean getLocation() {
		return location;
	}

	public void setLocation(Boolean location) {
		this.location = location;
	}

	public String getAte() {
		return ate;
	}

	public void setAte(String ate) {
		this.ate = ate;
	}

	public String getLetter() {
		return letter;
	}

	public void setLetter(String letter) {
		this.letter = letter;
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
        return "UserPrivacySettings{" +
                "id=" + id +
                ", userId=" + userId +
                ", comment=" + comment +
                ", location=" + location +
                ", ate=" + ate +
                ", letter=" + letter +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", delFlag=" + delFlag +
                "}";
	}
}
