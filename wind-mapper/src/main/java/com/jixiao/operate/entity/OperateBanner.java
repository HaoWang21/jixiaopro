package com.jixiao.operate.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 首页轮播
 * </p>
 *
 * @author jiang
 * @since 2018-10-09
 */
public class OperateBanner implements Serializable {

    private static final long serialVersionUID = 1L;

	@TableId(value = "id", type = IdType.AUTO)
	private Long id;
    /**
     * 图片
     */
	private String bannerUrl;
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
     * 备注
     */
	private String remark;
    /**
     * 活动Id
     */
	private Long activityId;
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


	public OperateBanner() {

	}

	private OperateBanner(Builder builder) {
		this.id = builder.id;
		this.bannerUrl = builder.bannerUrl;
		this.url = builder.url;
		this.beginTime = builder.beginTime;
		this.endTime = builder.endTime;
		this.seq = builder.seq;
		this.enable = builder.enable;
		this.remark = builder.remark;
		this.activityId = builder.activityId;
		this.createSysUserId = builder.createSysUserId;
		this.gmtCreate = builder.gmtCreate;
		this.gmtModified = builder.gmtModified;
		this.delFlag = builder.delFlag;
	}


	public static class Builder {

        private Long id;
        private String bannerUrl;
        private String url;
        private Date beginTime;
        private Date endTime;
        private Integer seq;
        private Boolean enable;
        private String remark;
        private Long activityId;
        private Long createSysUserId;
        private Date gmtCreate;
        private Date gmtModified;
        private Boolean delFlag;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }
        public Builder bannerUrl(String bannerUrl) {
            this.bannerUrl = bannerUrl;
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
        public Builder remark(String remark) {
            this.remark = remark;
            return this;
        }
        public Builder activityId(Long activityId) {
            this.activityId = activityId;
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

        public OperateBanner build() {
			return new OperateBanner(this);
		}
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBannerUrl() {
		return bannerUrl;
	}

	public void setBannerUrl(String bannerUrl) {
		this.bannerUrl = bannerUrl;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getActivityId() {
		return activityId;
	}

	public void setActivityId(Long activityId) {
		this.activityId = activityId;
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
        return "OperateBanner{" +
                "id=" + id +
                ", bannerUrl=" + bannerUrl +
                ", url=" + url +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", seq=" + seq +
                ", enable=" + enable +
                ", remark=" + remark +
                ", activityId=" + activityId +
                ", createSysUserId=" + createSysUserId +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", delFlag=" + delFlag +
                "}";
	}
}
