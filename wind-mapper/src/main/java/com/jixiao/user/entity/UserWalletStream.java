package com.jixiao.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 用户钱包流水
 * </p>
 *
 * @author jiang
 * @since 2018-10-08
 */
public class UserWalletStream implements Serializable {

    private static final long serialVersionUID = 1L;

	@TableId(value = "id", type = IdType.AUTO)
	private Long id;
    /**
     * 用户Id
     */
	private Long userId;
    /**
     * 操作前余额
     */
	private BigDecimal beforeBalance;
    /**
     * 余额
     */
	private BigDecimal balance;
    /**
     * 操作前消费券
     */
	private BigDecimal beforeConsumeCoupon;
    /**
     * 消费券
     */
	private BigDecimal consumeCoupon;
    /**
     * 操作前金币
     */
	private Integer beforeGoldCoin;
    /**
     * 金币
     */
	private Integer goldCoin;
    /**
     * 操作前银币
     */
	private Integer beforeSilverCoin;
    /**
     * 银币
     */
	private Integer silverCoin;
    /**
     * 操作前铜币
     */
	private Integer beforeCopperCoin;
    /**
     * 铜币
     */
	private Integer copperCoin;
    /**
     * 备注
     */
	private String remark;
    /**
     * 余额流水：1是 0否
     */
	private Boolean checkBalance;
    /**
     * 消费券流水：1是 0否
     */
	private Boolean checkConsumeCoupon;
    /**
     * 金币流水：1是 0否
     */
	private Boolean checkGoldCoin;
    /**
     * 银币流水：1是 0否
     */
	private Boolean checkSilverCoin;
    /**
     * 铜币流水：1是 0否
     */
	private Boolean checkCopperCoin;
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


	public UserWalletStream() {

	}

	private UserWalletStream(Builder builder) {
		this.id = builder.id;
		this.userId = builder.userId;
		this.beforeBalance = builder.beforeBalance;
		this.balance = builder.balance;
		this.beforeConsumeCoupon = builder.beforeConsumeCoupon;
		this.consumeCoupon = builder.consumeCoupon;
		this.beforeGoldCoin = builder.beforeGoldCoin;
		this.goldCoin = builder.goldCoin;
		this.beforeSilverCoin = builder.beforeSilverCoin;
		this.silverCoin = builder.silverCoin;
		this.beforeCopperCoin = builder.beforeCopperCoin;
		this.copperCoin = builder.copperCoin;
		this.remark = builder.remark;
		this.checkBalance = builder.checkBalance;
		this.checkConsumeCoupon = builder.checkConsumeCoupon;
		this.checkGoldCoin = builder.checkGoldCoin;
		this.checkSilverCoin = builder.checkSilverCoin;
		this.checkCopperCoin = builder.checkCopperCoin;
		this.gmtCreate = builder.gmtCreate;
		this.gmtModified = builder.gmtModified;
		this.delFlag = builder.delFlag;
	}


	public static class Builder {

        private Long id;
        private Long userId;
        private BigDecimal beforeBalance;
        private BigDecimal balance;
        private BigDecimal beforeConsumeCoupon;
        private BigDecimal consumeCoupon;
        private Integer beforeGoldCoin;
        private Integer goldCoin;
        private Integer beforeSilverCoin;
        private Integer silverCoin;
        private Integer beforeCopperCoin;
        private Integer copperCoin;
        private String remark;
        private Boolean checkBalance;
        private Boolean checkConsumeCoupon;
        private Boolean checkGoldCoin;
        private Boolean checkSilverCoin;
        private Boolean checkCopperCoin;
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
        public Builder beforeBalance(BigDecimal beforeBalance) {
            this.beforeBalance = beforeBalance;
            return this;
        }
        public Builder balance(BigDecimal balance) {
            this.balance = balance;
            return this;
        }
        public Builder beforeConsumeCoupon(BigDecimal beforeConsumeCoupon) {
            this.beforeConsumeCoupon = beforeConsumeCoupon;
            return this;
        }
        public Builder consumeCoupon(BigDecimal consumeCoupon) {
            this.consumeCoupon = consumeCoupon;
            return this;
        }
        public Builder beforeGoldCoin(Integer beforeGoldCoin) {
            this.beforeGoldCoin = beforeGoldCoin;
            return this;
        }
        public Builder goldCoin(Integer goldCoin) {
            this.goldCoin = goldCoin;
            return this;
        }
        public Builder beforeSilverCoin(Integer beforeSilverCoin) {
            this.beforeSilverCoin = beforeSilverCoin;
            return this;
        }
        public Builder silverCoin(Integer silverCoin) {
            this.silverCoin = silverCoin;
            return this;
        }
        public Builder beforeCopperCoin(Integer beforeCopperCoin) {
            this.beforeCopperCoin = beforeCopperCoin;
            return this;
        }
        public Builder copperCoin(Integer copperCoin) {
            this.copperCoin = copperCoin;
            return this;
        }
        public Builder remark(String remark) {
            this.remark = remark;
            return this;
        }
        public Builder checkBalance(Boolean checkBalance) {
            this.checkBalance = checkBalance;
            return this;
        }
        public Builder checkConsumeCoupon(Boolean checkConsumeCoupon) {
            this.checkConsumeCoupon = checkConsumeCoupon;
            return this;
        }
        public Builder checkGoldCoin(Boolean checkGoldCoin) {
            this.checkGoldCoin = checkGoldCoin;
            return this;
        }
        public Builder checkSilverCoin(Boolean checkSilverCoin) {
            this.checkSilverCoin = checkSilverCoin;
            return this;
        }
        public Builder checkCopperCoin(Boolean checkCopperCoin) {
            this.checkCopperCoin = checkCopperCoin;
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

        public UserWalletStream build() {
			return new UserWalletStream(this);
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

	public BigDecimal getBeforeBalance() {
		return beforeBalance;
	}

	public void setBeforeBalance(BigDecimal beforeBalance) {
		this.beforeBalance = beforeBalance;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public BigDecimal getBeforeConsumeCoupon() {
		return beforeConsumeCoupon;
	}

	public void setBeforeConsumeCoupon(BigDecimal beforeConsumeCoupon) {
		this.beforeConsumeCoupon = beforeConsumeCoupon;
	}

	public BigDecimal getConsumeCoupon() {
		return consumeCoupon;
	}

	public void setConsumeCoupon(BigDecimal consumeCoupon) {
		this.consumeCoupon = consumeCoupon;
	}

	public Integer getBeforeGoldCoin() {
		return beforeGoldCoin;
	}

	public void setBeforeGoldCoin(Integer beforeGoldCoin) {
		this.beforeGoldCoin = beforeGoldCoin;
	}

	public Integer getGoldCoin() {
		return goldCoin;
	}

	public void setGoldCoin(Integer goldCoin) {
		this.goldCoin = goldCoin;
	}

	public Integer getBeforeSilverCoin() {
		return beforeSilverCoin;
	}

	public void setBeforeSilverCoin(Integer beforeSilverCoin) {
		this.beforeSilverCoin = beforeSilverCoin;
	}

	public Integer getSilverCoin() {
		return silverCoin;
	}

	public void setSilverCoin(Integer silverCoin) {
		this.silverCoin = silverCoin;
	}

	public Integer getBeforeCopperCoin() {
		return beforeCopperCoin;
	}

	public void setBeforeCopperCoin(Integer beforeCopperCoin) {
		this.beforeCopperCoin = beforeCopperCoin;
	}

	public Integer getCopperCoin() {
		return copperCoin;
	}

	public void setCopperCoin(Integer copperCoin) {
		this.copperCoin = copperCoin;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Boolean getCheckBalance() {
		return checkBalance;
	}

	public void setCheckBalance(Boolean checkBalance) {
		this.checkBalance = checkBalance;
	}

	public Boolean getCheckConsumeCoupon() {
		return checkConsumeCoupon;
	}

	public void setCheckConsumeCoupon(Boolean checkConsumeCoupon) {
		this.checkConsumeCoupon = checkConsumeCoupon;
	}

	public Boolean getCheckGoldCoin() {
		return checkGoldCoin;
	}

	public void setCheckGoldCoin(Boolean checkGoldCoin) {
		this.checkGoldCoin = checkGoldCoin;
	}

	public Boolean getCheckSilverCoin() {
		return checkSilverCoin;
	}

	public void setCheckSilverCoin(Boolean checkSilverCoin) {
		this.checkSilverCoin = checkSilverCoin;
	}

	public Boolean getCheckCopperCoin() {
		return checkCopperCoin;
	}

	public void setCheckCopperCoin(Boolean checkCopperCoin) {
		this.checkCopperCoin = checkCopperCoin;
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
        return "UserWalletStream{" +
                "id=" + id +
                ", userId=" + userId +
                ", beforeBalance=" + beforeBalance +
                ", balance=" + balance +
                ", beforeConsumeCoupon=" + beforeConsumeCoupon +
                ", consumeCoupon=" + consumeCoupon +
                ", beforeGoldCoin=" + beforeGoldCoin +
                ", goldCoin=" + goldCoin +
                ", beforeSilverCoin=" + beforeSilverCoin +
                ", silverCoin=" + silverCoin +
                ", beforeCopperCoin=" + beforeCopperCoin +
                ", copperCoin=" + copperCoin +
                ", remark=" + remark +
                ", checkBalance=" + checkBalance +
                ", checkConsumeCoupon=" + checkConsumeCoupon +
                ", checkGoldCoin=" + checkGoldCoin +
                ", checkSilverCoin=" + checkSilverCoin +
                ", checkCopperCoin=" + checkCopperCoin +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", delFlag=" + delFlag +
                "}";
	}
}
