package com.jixiao.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 用户动态设置
 * </p>
 *
 * @author jiang
 * @since 2018-10-08
 */
public class UserDynamicSettings implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 用户动态Id
     */
    private Long userDynamicId;
    /**
     * 经度
     */
    private BigDecimal lng;
    /**
     * 纬度
     */
    private BigDecimal lat;
    /**
     * 地址
     */
    private String address;
    /**
     * 那些人可以查看这条动态
     */
    private String browse;
    /**
     * 提醒谁看拼接用户Id
     */
    private String ateUserId;
    /**
     * 定时动态到时间删除
     */
    private Date timing;
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


    public UserDynamicSettings() {

    }

    private UserDynamicSettings(Builder builder) {
        this.id = builder.id;
        this.userDynamicId = builder.userDynamicId;
        this.lng = builder.lng;
        this.lat = builder.lat;
        this.address = builder.address;
        this.browse = builder.browse;
        this.ateUserId = builder.ateUserId;
        this.timing = builder.timing;
        this.gmtCreate = builder.gmtCreate;
        this.gmtModified = builder.gmtModified;
        this.delFlag = builder.delFlag;
    }


    public static class Builder {

        private Long id;
        private Long userDynamicId;
        private BigDecimal lng;
        private BigDecimal lat;
        private String address;
        private String browse;
        private String ateUserId;
        private Date timing;
        private Date gmtCreate;
        private Date gmtModified;
        private Boolean delFlag;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder userDynamicId(Long userDynamicId) {
            this.userDynamicId = userDynamicId;
            return this;
        }

        public Builder lng(BigDecimal lng) {
            this.lng = lng;
            return this;
        }

        public Builder lat(BigDecimal lat) {
            this.lat = lat;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder browse(String browse) {
            this.browse = browse;
            return this;
        }

        public Builder ateUserId(String ateUserId) {
            this.ateUserId = ateUserId;
            return this;
        }

        public Builder timing(Date timing) {
            this.timing = timing;
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

        public UserDynamicSettings build() {
            return new UserDynamicSettings(this);
        }
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserDynamicId() {
        return userDynamicId;
    }

    public void setUserDynamicId(Long userDynamicId) {
        this.userDynamicId = userDynamicId;
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

    public String getAteUserId() {
        return ateUserId;
    }

    public void setAteUserId(String ateUserId) {
        this.ateUserId = ateUserId;
    }

    public Date getTiming() {
        return timing;
    }

    public void setTiming(Date timing) {
        this.timing = timing;
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
        return "UserDynamicSettings{" +
                "id=" + id +
                ", userDynamicId=" + userDynamicId +
                ", lng=" + lng +
                ", lat=" + lat +
                ", address=" + address +
                ", browse=" + browse +
                ", ateUserId=" + ateUserId +
                ", timing=" + timing +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", delFlag=" + delFlag +
                "}";
    }
}
