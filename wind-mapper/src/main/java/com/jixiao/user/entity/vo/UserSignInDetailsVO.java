package com.jixiao.user.entity.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 用户签到详情vo
 * </p>
 *
 * @author jiang
 * @since 2018-09-30
 */
public class UserSignInDetailsVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "我的铜币")
    private Integer copperCoin;
    @ApiModelProperty(value = "是否签到")
    private Boolean check;
    @ApiModelProperty(value = "当前签到能获得的铜币")
    private Integer nowCopperCoin;
    @ApiModelProperty(value = "连续签到天数")
    private Integer continuityNail;
    @ApiModelProperty(value = "签到获得的铜币")
    private Integer continuityCopperCoin;
    @ApiModelProperty(value = "签到记录")
    private List<UserSignInListVO> list;

    public Integer getCopperCoin() {
        return copperCoin;
    }

    public void setCopperCoin(Integer copperCoin) {
        this.copperCoin = copperCoin;
    }

    public Boolean getCheck() {
        return check;
    }

    public void setCheck(Boolean check) {
        this.check = check;
    }

    public Integer getNowCopperCoin() {
        return nowCopperCoin;
    }

    public void setNowCopperCoin(Integer nowCopperCoin) {
        this.nowCopperCoin = nowCopperCoin;
    }

    public Integer getContinuityNail() {
        return continuityNail;
    }

    public void setContinuityNail(Integer continuityNail) {
        this.continuityNail = continuityNail;
    }

    public Integer getContinuityCopperCoin() {
        return continuityCopperCoin;
    }

    public void setContinuityCopperCoin(Integer continuityCopperCoin) {
        this.continuityCopperCoin = continuityCopperCoin;
    }

    public List<UserSignInListVO> getList() {
        return list;
    }

    public void setList(List<UserSignInListVO> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "UserSignInDetailsVO{" +
                "copperCoin=" + copperCoin +
                ", check=" + check +
                ", nowCopperCoin=" + nowCopperCoin +
                ", continuityNail=" + continuityNail +
                ", continuityCopperCoin=" + continuityCopperCoin +
                ", list=" + list +
                '}';
    }
}
