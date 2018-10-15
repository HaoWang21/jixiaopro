package com.jixiao.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 用户评论
 * </p>
 *
 * @author jiang
 * @since 2018-10-10
 */
public class UserComment implements Serializable {

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
     * 内容
     */
	private String content;
    /**
     * 回复的评论Id
     */
	private Long replyUserCommentId;
    /**
     * 回复的用户Id
     */
	private Long replyUserId;
    /**
     * 上级Id
     */
	private Long parentId;
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


	public UserComment() {

	}

	private UserComment(Builder builder) {
		this.id = builder.id;
		this.userDynamicId = builder.userDynamicId;
		this.userId = builder.userId;
		this.content = builder.content;
		this.replyUserCommentId = builder.replyUserCommentId;
		this.replyUserId = builder.replyUserId;
		this.parentId = builder.parentId;
		this.gmtCreate = builder.gmtCreate;
		this.gmtModified = builder.gmtModified;
		this.delFlag = builder.delFlag;
	}


	public static class Builder {

        private Long id;
        private Long userDynamicId;
        private Long userId;
        private String content;
        private Long replyUserCommentId;
        private Long replyUserId;
        private Long parentId;
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
        public Builder content(String content) {
            this.content = content;
            return this;
        }
        public Builder replyUserCommentId(Long replyUserCommentId) {
            this.replyUserCommentId = replyUserCommentId;
            return this;
        }
        public Builder replyUserId(Long replyUserId) {
            this.replyUserId = replyUserId;
            return this;
        }
        public Builder parentId(Long parentId) {
            this.parentId = parentId;
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

        public UserComment build() {
			return new UserComment(this);
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getReplyUserCommentId() {
		return replyUserCommentId;
	}

	public void setReplyUserCommentId(Long replyUserCommentId) {
		this.replyUserCommentId = replyUserCommentId;
	}

	public Long getReplyUserId() {
		return replyUserId;
	}

	public void setReplyUserId(Long replyUserId) {
		this.replyUserId = replyUserId;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
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
        return "UserComment{" +
                "id=" + id +
                ", userDynamicId=" + userDynamicId +
                ", userId=" + userId +
                ", content=" + content +
                ", replyUserCommentId=" + replyUserCommentId +
                ", replyUserId=" + replyUserId +
                ", parentId=" + parentId +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", delFlag=" + delFlag +
                "}";
	}
}
