package com.jixiao.operate.entity.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>
 * 轮播
 * </p>
 *
 * @author jiang
 * @since 2018-10-09
 */
public class OperateBannerVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value = "轮播图")
    private String bannerUrl;
    @ApiModelProperty(value = "链接")
    private String url;
    @ApiModelProperty(value = "是否是活动")
    private Boolean activity;
    @ApiModelProperty(value = "活动链接")
    private String activityUrl;

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

    public Boolean getActivity() {
        return activity;
    }

    public void setActivity(Boolean activity) {
        this.activity = activity;
    }

    public String getActivityUrl() {
        return activityUrl;
    }

    public void setActivityUrl(String activityUrl) {
        this.activityUrl = activityUrl;
    }

    @Override
    public String toString() {
        return "OperateBannerVO{" +
                "id=" + id +
                ", bannerUrl='" + bannerUrl + '\'' +
                ", url='" + url + '\'' +
                ", activity=" + activity +
                ", activityUrl='" + activityUrl + '\'' +
                '}';
    }
}
