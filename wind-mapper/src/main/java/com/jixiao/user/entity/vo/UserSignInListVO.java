package com.jixiao.user.entity.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>
 * 用户签到列表vo
 * </p>
 *
 * @author jiang
 * @since 2018-09-30
 */
public class UserSignInListVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "连续签到天数")
    private Integer continuity;
    @ApiModelProperty(value = "铜币")
    private Integer copperCoin;
    @ApiModelProperty(value = "签到时间")
    private String gmtCreate;

    public Integer getContinuity() {
        return continuity;
    }

    public void setContinuity(Integer continuity) {
        this.continuity = continuity;
    }

    public Integer getCopperCoin() {
        return copperCoin;
    }

    public void setCopperCoin(Integer copperCoin) {
        this.copperCoin = copperCoin;
    }

    public String getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(String gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    @Override
    public String toString() {
        return "UserSignInListVO{" +
                "continuity=" + continuity +
                ", copperCoin=" + copperCoin +
                ", gmtCreate='" + gmtCreate + '\'' +
                '}';
    }
}
