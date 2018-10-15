package com.jixiao.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 用户钱包
 * </p>
 *
 * @author jiang
 * @since 2018-10-08
 */
public class UserWallet implements Serializable {

    private static final long serialVersionUID = 1L;

	@TableId(value = "id", type = IdType.AUTO)
	private Long id;
    /**
     * 用户Id
     */
	private Long userId;
    /**
     * 余额
     */
	private BigDecimal balance;
    /**
     * 消费券
     */
	private BigDecimal consumeCoupon;
    /**
     * 金币（推广）
     */
	private Integer goldCoin;
    /**
     * 银币（消费）
     */
	private Integer silverCoin;
    /**
     * 铜币（赠送）
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


	public UserWallet() {

	}

	private UserWallet(Builder builder) {
		this.id = builder.id;
		this.userId = builder.userId;
		this.balance = builder.balance;
		this.consumeCoupon = builder.consumeCoupon;
		this.goldCoin = builder.goldCoin;
		this.silverCoin = builder.silverCoin;
		this.copperCoin = builder.copperCoin;
		this.gmtCreate = builder.gmtCreate;
		this.gmtModified = builder.gmtModified;
		this.delFlag = builder.delFlag;
	}


	public static class Builder {

        private Long id;
        private Long userId;
        private BigDecimal balance;
        private BigDecimal consumeCoupon;
        private Integer goldCoin;
        private Integer silverCoin;
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
        public Builder balance(BigDecimal balance) {
            this.balance = balance;
            return this;
        }
        public Builder consumeCoupon(BigDecimal consumeCoupon) {
            this.consumeCoupon = consumeCoupon;
            return this;
        }
        public Builder goldCoin(Integer goldCoin) {
            this.goldCoin = goldCoin;
            return this;
        }
        public Builder silverCoin(Integer silverCoin) {
            this.silverCoin = silverCoin;
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

        public UserWallet build() {
			return new UserWallet(this);
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

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public BigDecimal getConsumeCoupon() {
		return consumeCoupon;
	}

	public void setConsumeCoupon(BigDecimal consumeCoupon) {
		this.consumeCoupon = consumeCoupon;
	}

	public Integer getGoldCoin() {
		return goldCoin;
	}

	public void setGoldCoin(Integer goldCoin) {
		this.goldCoin = goldCoin;
	}

	public Integer getSilverCoin() {
		return silverCoin;
	}

	public void setSilverCoin(Integer silverCoin) {
		this.silverCoin = silverCoin;
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
        return "UserWallet{" +
                "id=" + id +
                ", userId=" + userId +
                ", balance=" + balance +
                ", consumeCoupon=" + consumeCoupon +
                ", goldCoin=" + goldCoin +
                ", silverCoin=" + silverCoin +
                ", copperCoin=" + copperCoin +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", delFlag=" + delFlag +
                "}";
	}
}
