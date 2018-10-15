package com.jixiao.user.entity.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 用户隐私设置详情vo
 * </p>
 *
 * @author jiang
 * @since 2018-10-01
 */
public class UserPrivacySettingsDetailsVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "那些人可以评论我的动态'ALL','FOLLOW','FANS'")
    private String comment;
    @ApiModelProperty(value = "是否开启附近的人")
    private Boolean location;
    @ApiModelProperty(value = "我可以收到那些人的@提醒'ALL','FOLLOW','FANS'")
    private String ate;
    @ApiModelProperty(value = "我可以收到那些人的私信'ALL','FOLLOW','FANS'")
    private String letter;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Boolean getLocation() {
        return location;
    }

    public void setLocation(Boolean location) {
        this.location = location;
    }

    public String getAte() {
        return ate;
    }

    public void setAte(String ate) {
        this.ate = ate;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    @Override
    public String toString() {
        return "UserPrivacySettingsDetailsVO{" +
                "comment=" + comment +
                ", location=" + location +
                ", ate=" + ate +
                ", letter=" + letter +
                '}';
    }
}
