package com.jixiao.operate.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 活动
 * </p>
 *
 * @author jiang
 * @since 2018-10-09
 */
public class OperateActivity implements Serializable {

    private static final long serialVersionUID = 1L;

	@TableId(value = "id", type = IdType.AUTO)
	private Long id;
    /**
     * 标题
     */
	private String title;
    /**
     * 封面图
     */
	private String coverUrl;
    /**
     * 摘要
     */
	private String summary;
    /**
     * 弹窗图
     */
	private String popupUrl;
    /**
     * 链接
     */
	private String url;
    /**
     * 开始时间
     */
	private Date beginTime;
    /**
     * 结束时间
     */
	private Date endTime;
    /**
     * 排序
     */
	private Integer seq;
    /**
     * 是否启用：1是 0否
     */
	private Boolean enable;
    /**
     * 是否弹窗：1是 0否
     */
	private Boolean popup;
    /**
     * 状态：0未发布 1展示中 2人工下架
     */
	private Integer status;
    /**
     * 备注
     */
	private String remark;
    /**
     * 创建人Id
     */
	private Long createSysUserId;
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


	public OperateActivity() {

	}

	private OperateActivity(Builder builder) {
		this.id = builder.id;
		this.title = builder.title;
		this.coverUrl = builder.coverUrl;
		this.summary = builder.summary;
		this.popupUrl = builder.popupUrl;
		this.url = builder.url;
		this.beginTime = builder.beginTime;
		this.endTime = builder.endTime;
		this.seq = builder.seq;
		this.enable = builder.enable;
		this.popup = builder.popup;
		this.status = builder.status;
		this.remark = builder.remark;
		this.createSysUserId = builder.createSysUserId;
		this.gmtCreate = builder.gmtCreate;
		this.gmtModified = builder.gmtModified;
		this.delFlag = builder.delFlag;
	}


	public static class Builder {

        private Long id;
        private String title;
        private String coverUrl;
        private String summary;
        private String popupUrl;
        private String url;
        private Date beginTime;
        private Date endTime;
        private Integer seq;
        private Boolean enable;
        private Boolean popup;
        private Integer status;
        private String remark;
        private Long createSysUserId;
        private Date gmtCreate;
        private Date gmtModified;
        private Boolean delFlag;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }
        public Builder title(String title) {
            this.title = title;
            return this;
        }
        public Builder coverUrl(String coverUrl) {
            this.coverUrl = coverUrl;
            return this;
        }
        public Builder summary(String summary) {
            this.summary = summary;
            return this;
        }
        public Builder popupUrl(String popupUrl) {
            this.popupUrl = popupUrl;
            return this;
        }
        public Builder url(String url) {
            this.url = url;
            return this;
        }
        public Builder beginTime(Date beginTime) {
            this.beginTime = beginTime;
            return this;
        }
        public Builder endTime(Date endTime) {
            this.endTime = endTime;
            return this;
        }
        public Builder seq(Integer seq) {
            this.seq = seq;
            return this;
        }
        public Builder enable(Boolean enable) {
            this.enable = enable;
            return this;
        }
        public Builder popup(Boolean popup) {
            this.popup = popup;
            return this;
        }
        public Builder status(Integer status) {
            this.status = status;
            return this;
        }
        public Builder remark(String remark) {
            this.remark = remark;
            return this;
        }
        public Builder createSysUserId(Long createSysUserId) {
            this.createSysUserId = createSysUserId;
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

        public OperateActivity build() {
			return new OperateActivity(this);
		}
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCoverUrl() {
		return coverUrl;
	}

	public void setCoverUrl(String coverUrl) {
		this.coverUrl = coverUrl;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getPopupUrl() {
		return popupUrl;
	}

	public void setPopupUrl(String popupUrl) {
		this.popupUrl = popupUrl;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	public Boolean getPopup() {
		return popup;
	}

	public void setPopup(Boolean popup) {
		this.popup = popup;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getCreateSysUserId() {
		return createSysUserId;
	}

	public void setCreateSysUserId(Long createSysUserId) {
		this.createSysUserId = createSysUserId;
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
        return "OperateActivity{" +
                "id=" + id +
                ", title=" + title +
                ", coverUrl=" + coverUrl +
                ", summary=" + summary +
                ", popupUrl=" + popupUrl +
                ", url=" + url +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", seq=" + seq +
                ", enable=" + enable +
                ", popup=" + popup +
                ", status=" + status +
                ", remark=" + remark +
                ", createSysUserId=" + createSysUserId +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", delFlag=" + delFlag +
                "}";
	}
}
