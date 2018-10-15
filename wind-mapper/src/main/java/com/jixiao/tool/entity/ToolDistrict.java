package com.jixiao.tool.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 行政区域
 * </p>
 *
 * @author jiang
 * @since 2018-09-28
 */
public class ToolDistrict implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 行政区名称
     */
    private String name;
    /**
     * 城市编码
     */
    private String cityCode;
    /**
     * 区域编码
     */
    private String adCode;
    /**
     * 经度
     */
    private BigDecimal lng;
    /**
     * 纬度
     */
    private BigDecimal lat;
    /**
     * 行政区划级别: 0国家 1省份 2市 3区县 4街道
     */
    private Integer level;
    /**
     * 排序
     */
    private Integer seq;
    /**
     * 上级Id
     */
    private Long parentId;
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


    public ToolDistrict() {

    }

    private ToolDistrict(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.cityCode = builder.cityCode;
        this.adCode = builder.adCode;
        this.lng = builder.lng;
        this.lat = builder.lat;
        this.level = builder.level;
        this.seq = builder.seq;
        this.parentId = builder.parentId;
        this.gmtCreate = builder.gmtCreate;
        this.gmtModified = builder.gmtModified;
        this.delFlag = builder.delFlag;
    }


    public static class Builder {

        private Long id;
        private String name;
        private String cityCode;
        private String adCode;
        private BigDecimal lng;
        private BigDecimal lat;
        private Integer level;
        private Integer seq;
        private Long parentId;
        private Date gmtCreate;
        private Date gmtModified;
        private Boolean delFlag;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder cityCode(String cityCode) {
            this.cityCode = cityCode;
            return this;
        }

        public Builder adCode(String adCode) {
            this.adCode = adCode;
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

        public Builder level(Integer level) {
            this.level = level;
            return this;
        }

        public Builder seq(Integer seq) {
            this.seq = seq;
            return this;
        }

        public Builder parentId(Long parentId) {
            this.parentId = parentId;
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

        public ToolDistrict build() {
            return new ToolDistrict(this);
        }
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getAdCode() {
        return adCode;
    }

    public void setAdCode(String adCode) {
        this.adCode = adCode;
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

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
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
        return "ToolDistrict{" +
                "id=" + id +
                ", name=" + name +
                ", cityCode=" + cityCode +
                ", adCode=" + adCode +
                ", lng=" + lng +
                ", lat=" + lat +
                ", level=" + level +
                ", seq=" + seq +
                ", parentId=" + parentId +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", delFlag=" + delFlag +
                "}";
    }
}
