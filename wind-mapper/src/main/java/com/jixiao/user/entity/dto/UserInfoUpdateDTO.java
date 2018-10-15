package com.jixiao.user.entity.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>
 * 用户信息修改dto
 * </p>
 *
 * @author jiang
 * @since 2018-09-29
 */
public class UserInfoUpdateDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "背景图")
    private String backdropUrl;
    @ApiModelProperty(value = "头像框")
    private String avatarCaseUrl;
    @ApiModelProperty(value = "昵称")
    private String nickName;
    @ApiModelProperty(value = "头像")
    private String avatarUrl;
    @ApiModelProperty(value = "性别：0未知 1男 2女")
    private Integer gender;
    @ApiModelProperty(value = "省Id")
    private Long provinceId;
    @ApiModelProperty(value = "市Id")
    private Long cityId;
    @ApiModelProperty(value = "区Id")
    private Long areaId;
    @ApiModelProperty(value = "地址")
    private String address;

    public String getBackdropUrl() {
        return backdropUrl;
    }

    public void setBackdropUrl(String backdropUrl) {
        this.backdropUrl = backdropUrl;
    }

    public String getAvatarCaseUrl() {
        return avatarCaseUrl;
    }

    public void setAvatarCaseUrl(String avatarCaseUrl) {
        this.avatarCaseUrl = avatarCaseUrl;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
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

    @Override
    public String toString() {
        return "UserInfoUpdateDTO{" +
                "backdropUrl='" + backdropUrl + '\'' +
                ", avatarCaseUrl='" + avatarCaseUrl + '\'' +
                ", nickName='" + nickName + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", gender=" + gender +
                ", provinceId=" + provinceId +
                ", cityId=" + cityId +
                ", areaId=" + areaId +
                ", address='" + address + '\'' +
                '}';
    }
}
