package com.jixiao.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 用户信息
 * </p>
 *
 * @author jiang
 * @since 2018-10-08
 */
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

	@TableId(value = "id", type = IdType.AUTO)
	private Long id;
    /**
     * 用户Id
     */
	private Long userId;
    /**
     * 昵称
     */
	private String nickName;
    /**
     * 头像
     */
	private String avatarUrl;
    /**
     * 性别：0未知 1男 2女
     */
	private Integer gender;
    /**
     * 背景图
     */
	private String backdropUrl;
    /**
     * 头像框
     */
	private String avatarCaseUrl;
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
     * 地址
     */
	private String address;
    /**
     * 角色：0普通会员 1学生会员 2推广合伙人
     */
	private Integer role;
    /**
     * 邀请码
     */
	private String refereeCode;
    /**
     * 小程序邀请二维码
     */
	private String refereeUrl;
    /**
     * 邀请人用户Id
     */
	private Long refereeUserId;
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


	public UserInfo() {

	}

	private UserInfo(Builder builder) {
		this.id = builder.id;
		this.userId = builder.userId;
		this.nickName = builder.nickName;
		this.avatarUrl = builder.avatarUrl;
		this.gender = builder.gender;
		this.backdropUrl = builder.backdropUrl;
		this.avatarCaseUrl = builder.avatarCaseUrl;
		this.provinceToolDistrictId = builder.provinceToolDistrictId;
		this.cityToolDistrictId = builder.cityToolDistrictId;
		this.areaToolDistrictId = builder.areaToolDistrictId;
		this.address = builder.address;
		this.role = builder.role;
		this.refereeCode = builder.refereeCode;
		this.refereeUrl = builder.refereeUrl;
		this.refereeUserId = builder.refereeUserId;
		this.gmtCreate = builder.gmtCreate;
		this.gmtModified = builder.gmtModified;
		this.delFlag = builder.delFlag;
	}


	public static class Builder {

        private Long id;
        private Long userId;
        private String nickName;
        private String avatarUrl;
        private Integer gender;
        private String backdropUrl;
        private String avatarCaseUrl;
        private Long provinceToolDistrictId;
        private Long cityToolDistrictId;
        private Long areaToolDistrictId;
        private String address;
        private Integer role;
        private String refereeCode;
        private String refereeUrl;
        private Long refereeUserId;
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
        public Builder avatarUrl(String avatarUrl) {
            this.avatarUrl = avatarUrl;
            return this;
        }
        public Builder gender(Integer gender) {
            this.gender = gender;
            return this;
        }
        public Builder backdropUrl(String backdropUrl) {
            this.backdropUrl = backdropUrl;
            return this;
        }
        public Builder avatarCaseUrl(String avatarCaseUrl) {
            this.avatarCaseUrl = avatarCaseUrl;
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
        public Builder role(Integer role) {
            this.role = role;
            return this;
        }
        public Builder refereeCode(String refereeCode) {
            this.refereeCode = refereeCode;
            return this;
        }
        public Builder refereeUrl(String refereeUrl) {
            this.refereeUrl = refereeUrl;
            return this;
        }
        public Builder refereeUserId(Long refereeUserId) {
            this.refereeUserId = refereeUserId;
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

        public UserInfo build() {
			return new UserInfo(this);
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

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public String getRefereeCode() {
		return refereeCode;
	}

	public void setRefereeCode(String refereeCode) {
		this.refereeCode = refereeCode;
	}

	public String getRefereeUrl() {
		return refereeUrl;
	}

	public void setRefereeUrl(String refereeUrl) {
		this.refereeUrl = refereeUrl;
	}

	public Long getRefereeUserId() {
		return refereeUserId;
	}

	public void setRefereeUserId(Long refereeUserId) {
		this.refereeUserId = refereeUserId;
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
        return "UserInfo{" +
                "id=" + id +
                ", userId=" + userId +
                ", nickName=" + nickName +
                ", avatarUrl=" + avatarUrl +
                ", gender=" + gender +
                ", backdropUrl=" + backdropUrl +
                ", avatarCaseUrl=" + avatarCaseUrl +
                ", provinceToolDistrictId=" + provinceToolDistrictId +
                ", cityToolDistrictId=" + cityToolDistrictId +
                ", areaToolDistrictId=" + areaToolDistrictId +
                ", address=" + address +
                ", role=" + role +
                ", refereeCode=" + refereeCode +
                ", refereeUrl=" + refereeUrl +
                ", refereeUserId=" + refereeUserId +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", delFlag=" + delFlag +
                "}";
	}
}
