package com.jixiao.user.entity.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>
 * 用户地址修改dto
 * </p>
 *
 * @author jiang
 * @since 2018-09-28
 */
public class UserAddressUpdateDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "昵称", required = true)
    private String nickName;
    @ApiModelProperty(value = "手机号", required = true)
    private String mobile;
    @ApiModelProperty(value = "省Id", required = true)
    private Long provinceId;
    @ApiModelProperty(value = "市Id")
    private Long cityId;
    @ApiModelProperty(value = "区Id")
    private Long areaId;
    @ApiModelProperty(value = "详细地址", required = true)
    private String address;
    @ApiModelProperty(value = "是否是默认地址", dataType = "0")
    private Boolean defaultAddress;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getDefaultAddress() {
        return defaultAddress;
    }

    public void setDefaultAddress(Boolean defaultAddress) {
        this.defaultAddress = defaultAddress;
    }

    @Override
    public String toString() {
        return "UserAddressUpdateDTO{" +
                "nickName='" + nickName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", provinceId=" + provinceId +
                ", cityId=" + cityId +
                ", areaId=" + areaId +
                ", address='" + address + '\'' +
                ", defaultAddress=" + defaultAddress +
                '}';
    }
}
