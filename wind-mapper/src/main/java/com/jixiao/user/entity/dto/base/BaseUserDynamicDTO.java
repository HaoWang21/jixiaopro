package com.jixiao.user.entity.dto.base;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 发布动态父类
 * </p>
 *
 * @author jiang
 * @since 2018-10-09
 */
public class BaseUserDynamicDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "分类Id")
    private Long typeId;
    @ApiModelProperty(value = "经度")
    private BigDecimal lng;
    @ApiModelProperty(value = "纬度")
    private BigDecimal lat;
    @ApiModelProperty(value = "地址")
    private String address;
    @ApiModelProperty(value = "谁可以看: ALL所有人 FOLLOW关注 FANS粉丝（默认ALL）", required = true, allowableValues = "ALL")
    private String browse;
    @ApiModelProperty(value = "@谁查看")
    private String ateUserIds;

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public BigDecimal getLng() {
        return lng;
    }

    public void setLng(BigDecimal lng) {
        this.lng = lng;
    }

    public BigDecimal getLat() {
        return lat;
    }

    public void setLat(BigDecimal lat) {
        this.lat = lat;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBrowse() {
        return browse;
    }

    public void setBrowse(String browse) {
        this.browse = browse;
    }

    public String getAteUserIds() {
        return ateUserIds;
    }

    public void setAteUserIds(String ateUserIds) {
        this.ateUserIds = ateUserIds;
    }

    @Override
    public String toString() {
        return "BaseUserDynamicDTO{" +
                "typeId=" + typeId +
                ", lng=" + lng +
                ", lat=" + lat +
                ", address=" + address +
                ", browse=" + browse +
                ", ateUserIds=" + ateUserIds +
                '}';
    }
}
