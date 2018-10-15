package com.jixiao.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 用户地址
 * </p>
 *
 * @author jiang
 * @since 2018-10-08
 */
public class UserAddress implements Serializable {

    private static final long serialVersionUID = 1L;

	@TableId(value = "id", type = IdType.AUTO)
	private Long id;
    /**
     * 用户Id
     */
	private Long userId;
    /**
     * 收货人
     */
	private String nickName;
    /**
     * 手机号
     */
	private String mobile;
    /**
     * 省Id
     */
	private Long provinceToolDistrictId;
    /**
     * 市Id
     */
	private Long cityToolDistrictId;
    /**
     * 区Id
     */
	private Long areaToolDistrictId;
    /**
     * 详细地址
     */
	private String address;
    /**
     * 是否是默认地址：1是 0否
     */
	private Boolean defaultAddress;
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


	public UserAddress() {

	}

	private UserAddress(Builder builder) {
		this.id = builder.id;
		this.userId = builder.userId;
		this.nickName = builder.nickName;
		this.mobile = builder.mobile;
		this.provinceToolDistrictId = builder.provinceToolDistrictId;
		this.cityToolDistrictId = builder.cityToolDistrictId;
		this.areaToolDistrictId = builder.areaToolDistrictId;
		this.address = builder.address;
		this.defaultAddress = builder.defaultAddress;
		this.gmtCreate = builder.gmtCreate;
		this.gmtModified = builder.gmtModified;
		this.delFlag = builder.delFlag;
	}


	public static class Builder {

        private Long id;
        private Long userId;
        private String nickName;
        private String mobile;
        private Long provinceToolDistrictId;
        private Long cityToolDistrictId;
        private Long areaToolDistrictId;
        private String address;
        private Boolean defaultAddress;
        private Date gmtCreate;
        private Date gmtModified;
        private Boolean delFlag;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }
        public Builder userId(Long userId) {
            this.userId = userId;
            return this;
        }
        public Builder nickName(String nickName) {
            this.nickName = nickName;
            return this;
        }
        public Builder mobile(String mobile) {
            this.mobile = mobile;
            return this;
        }
        public Builder provinceToolDistrictId(Long provinceToolDistrictId) {
            this.provinceToolDistrictId = provinceToolDistrictId;
            return this;
        }
        public Builder cityToolDistrictId(Long cityToolDistrictId) {
            this.cityToolDistrictId = cityToolDistrictId;
            return this;
        }
        public Builder areaToolDistrictId(Long areaToolDistrictId) {
            this.areaToolDistrictId = areaToolDistrictId;
            return this;
        }
        public Builder address(String address) {
            this.address = address;
            return this;
        }
        public Builder defaultAddress(Boolean defaultAddress) {
            this.defaultAddress = defaultAddress;
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

        public UserAddress build() {
			return new UserAddress(this);
		}
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

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

	public Long getProvinceToolDistrictId() {
		return provinceToolDistrictId;
	}

	public void setProvinceToolDistrictId(Long provinceToolDistrictId) {
		this.provinceToolDistrictId = provinceToolDistrictId;
	}

	public Long getCityToolDistrictId() {
		return cityToolDistrictId;
	}

	public void setCityToolDistrictId(Long cityToolDistrictId) {
		this.cityToolDistrictId = cityToolDistrictId;
	}

	public Long getAreaToolDistrictId() {
		return areaToolDistrictId;
	}

	public void setAreaToolDistrictId(Long areaToolDistrictId) {
		this.areaToolDistrictId = areaToolDistrictId;
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
        return "UserAddress{" +
                "id=" + id +
                ", userId=" + userId +
                ", nickName=" + nickName +
                ", mobile=" + mobile +
                ", provinceToolDistrictId=" + provinceToolDistrictId +
                ", cityToolDistrictId=" + cityToolDistrictId +
                ", areaToolDistrictId=" + areaToolDistrictId +
                ", address=" + address +
                ", defaultAddress=" + defaultAddress +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", delFlag=" + delFlag +
                "}";
	}
}
