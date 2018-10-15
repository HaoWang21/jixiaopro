package com.jixiao.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 用户动态
 * </p>
 *
 * @author jiang
 * @since 2018-10-11
 */
public class UserDynamic implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 用户Id
     */
    private Long userId;
    /**
     * 内容
     */
    private String content;
    /**
     * 类目Id
     */
    private Long typeToolDictId;
    /**
     * 类型: 0文字动态 1文字图片 2文字视频
     */
    private Integer type;
    /**
     * 状态：0正常 1违规
     */
    private Integer status;
    /**
     * [转发]标题
     */
    private String title;
    /**
     * [转发]原动态Id
     */
    private Long originalUserDynamicId;
    /**
     * 转发次数
     */
    private Integer transmitCount;
    /**
     * 点赞次数
     */
    private Integer praiseCount;
    /**
     * 收藏次数
     */
    private Integer collectCount;
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


    public UserDynamic() {

    }

    private UserDynamic(Builder builder) {
        this.id = builder.id;
        this.userId = builder.userId;
        this.content = builder.content;
        this.typeToolDictId = builder.typeToolDictId;
        this.type = builder.type;
        this.status = builder.status;
        this.title = builder.title;
        this.originalUserDynamicId = builder.originalUserDynamicId;
        this.transmitCount = builder.transmitCount;
        this.praiseCount = builder.praiseCount;
        this.collectCount = builder.collectCount;
        this.gmtCreate = builder.gmtCreate;
        this.gmtModified = builder.gmtModified;
        this.delFlag = builder.delFlag;
    }


    public static class Builder {

        private Long id;
        private Long userId;
        private String content;
        private Long typeToolDictId;
        private Integer type;
        private Integer status;
        private String title;
        private Long originalUserDynamicId;
        private Integer transmitCount;
        private Integer praiseCount;
        private Integer collectCount;
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

        public Builder content(String content) {
            this.content = content;
            return this;
        }

        public Builder typeToolDictId(Long typeToolDictId) {
            this.typeToolDictId = typeToolDictId;
            return this;
        }

        public Builder type(Integer type) {
            this.type = type;
            return this;
        }

        public Builder status(Integer status) {
            this.status = status;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder originalUserDynamicId(Long originalUserDynamicId) {
            this.originalUserDynamicId = originalUserDynamicId;
            return this;
        }

        public Builder transmitCount(Integer transmitCount) {
            this.transmitCount = transmitCount;
            return this;
        }

        public Builder praiseCount(Integer praiseCount) {
            this.praiseCount = praiseCount;
            return this;
        }

        public Builder collectCount(Integer collectCount) {
            this.collectCount = collectCount;
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

        public UserDynamic build() {
            return new UserDynamic(this);
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getTypeToolDictId() {
        return typeToolDictId;
    }

    public void setTypeToolDictId(Long typeToolDictId) {
        this.typeToolDictId = typeToolDictId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getOriginalUserDynamicId() {
        return originalUserDynamicId;
    }

    public void setOriginalUserDynamicId(Long originalUserDynamicId) {
        this.originalUserDynamicId = originalUserDynamicId;
    }

    public Integer getTransmitCount() {
        return transmitCount;
    }

    public void setTransmitCount(Integer transmitCount) {
        this.transmitCount = transmitCount;
    }

    public Integer getPraiseCount() {
        return praiseCount;
    }

    public void setPraiseCount(Integer praiseCount) {
        this.praiseCount = praiseCount;
    }

    public Integer getCollectCount() {
        return collectCount;
    }

    public void setCollectCount(Integer collectCount) {
        this.collectCount = collectCount;
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
        return "UserDynamic{" +
                "id=" + id +
                ", userId=" + userId +
                ", content=" + content +
                ", typeToolDictId=" + typeToolDictId +
                ", type=" + type +
                ", status=" + status +
                ", title=" + title +
                ", originalUserDynamicId=" + originalUserDynamicId +
                ", transmitCount=" + transmitCount +
                ", praiseCount=" + praiseCount +
                ", collectCount=" + collectCount +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", delFlag=" + delFlag +
                "}";
    }
}
