package com.jixiao.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 用户签到
 * </p>
 *
 * @author jiang
 * @since 2018-10-08
 */
public class UserSignIn implements Serializable {

    private static final long serialVersionUID = 1L;

	@TableId(value = "id", type = IdType.AUTO)
	private Long id;
    /**
     * 用户Id
     */
	private Long userId;
    /**
     * 年
     */
	private Integer year;
    /**
     * 月
     */
	private Integer month;
    /**
     * 日
     */
	private Integer day;
    /**
     * 连续签到天数
     */
	private Integer continuity;
    /**
     * 铜币
     */
	private Integer copperCoin;
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


	public UserSignIn() {

	}

	private UserSignIn(Builder builder) {
		this.id = builder.id;
		this.userId = builder.userId;
		this.year = builder.year;
		this.month = builder.month;
		this.day = builder.day;
		this.continuity = builder.continuity;
		this.copperCoin = builder.copperCoin;
		this.gmtCreate = builder.gmtCreate;
		this.gmtModified = builder.gmtModified;
		this.delFlag = builder.delFlag;
	}


	public static class Builder {

        private Long id;
        private Long userId;
        private Integer year;
        private Integer month;
        private Integer day;
        private Integer continuity;
        private Integer copperCoin;
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
        public Builder year(Integer year) {
            this.year = year;
            return this;
        }
        public Builder month(Integer month) {
            this.month = month;
            return this;
        }
        public Builder day(Integer day) {
            this.day = day;
            return this;
        }
        public Builder continuity(Integer continuity) {
            this.continuity = continuity;
            return this;
        }
        public Builder copperCoin(Integer copperCoin) {
            this.copperCoin = copperCoin;
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

        public UserSignIn build() {
			return new UserSignIn(this);
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

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

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
        return "UserSignIn{" +
                "id=" + id +
                ", userId=" + userId +
                ", year=" + year +
                ", month=" + month +
                ", day=" + day +
                ", continuity=" + continuity +
                ", copperCoin=" + copperCoin +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", delFlag=" + delFlag +
                "}";
	}
}
