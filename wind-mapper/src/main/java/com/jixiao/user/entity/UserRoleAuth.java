package com.jixiao.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 用户角色认证
 * </p>
 *
 * @author jiang
 * @since 2018-10-08
 */
public class UserRoleAuth implements Serializable {

    private static final long serialVersionUID = 1L;

	@TableId(value = "id", type = IdType.AUTO)
	private Long id;
    /**
     * 用户Id
     */
	private Long userId;
    /**
     * 学生证
     */
	private String studentIdUrl;
    /**
     * 学籍号
     */
	private String studentCode;
    /**
     * 身份证（正反）
     */
	private String idCardUrl;
    /**
     * 类型：1学生会员 2推广合伙人
     */
	private Integer type;
    /**
     * 状态：0待审核 1不通过 2通过
     */
	private Integer status;
    /**
     * 备注
     */
	private String remark;
    /**
     * 申请时间（推广合伙人）
     */
	private Date gmtSpreadCreate;
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


	public UserRoleAuth() {

	}

	private UserRoleAuth(Builder builder) {
		this.id = builder.id;
		this.userId = builder.userId;
		this.studentIdUrl = builder.studentIdUrl;
		this.studentCode = builder.studentCode;
		this.idCardUrl = builder.idCardUrl;
		this.type = builder.type;
		this.status = builder.status;
		this.remark = builder.remark;
		this.gmtSpreadCreate = builder.gmtSpreadCreate;
		this.gmtCreate = builder.gmtCreate;
		this.gmtModified = builder.gmtModified;
		this.delFlag = builder.delFlag;
	}


	public static class Builder {

        private Long id;
        private Long userId;
        private String studentIdUrl;
        private String studentCode;
        private String idCardUrl;
        private Integer type;
        private Integer status;
        private String remark;
        private Date gmtSpreadCreate;
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
        public Builder studentIdUrl(String studentIdUrl) {
            this.studentIdUrl = studentIdUrl;
            return this;
        }
        public Builder studentCode(String studentCode) {
            this.studentCode = studentCode;
            return this;
        }
        public Builder idCardUrl(String idCardUrl) {
            this.idCardUrl = idCardUrl;
            return this;
        }
        public Builder type(Integer type) {
            this.type = type;
            return this;
        }
        public Builder status(Integer status) {
            this.status = status;
            return this;
        }
        public Builder remark(String remark) {
            this.remark = remark;
            return this;
        }
        public Builder gmtSpreadCreate(Date gmtSpreadCreate) {
            this.gmtSpreadCreate = gmtSpreadCreate;
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

        public UserRoleAuth build() {
			return new UserRoleAuth(this);
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

	public String getStudentIdUrl() {
		return studentIdUrl;
	}

	public void setStudentIdUrl(String studentIdUrl) {
		this.studentIdUrl = studentIdUrl;
	}

	public String getStudentCode() {
		return studentCode;
	}

	public void setStudentCode(String studentCode) {
		this.studentCode = studentCode;
	}

	public String getIdCardUrl() {
		return idCardUrl;
	}

	public void setIdCardUrl(String idCardUrl) {
		this.idCardUrl = idCardUrl;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getGmtSpreadCreate() {
		return gmtSpreadCreate;
	}

	public void setGmtSpreadCreate(Date gmtSpreadCreate) {
		this.gmtSpreadCreate = gmtSpreadCreate;
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
        return "UserRoleAuth{" +
                "id=" + id +
                ", userId=" + userId +
                ", studentIdUrl=" + studentIdUrl +
                ", studentCode=" + studentCode +
                ", idCardUrl=" + idCardUrl +
                ", type=" + type +
                ", status=" + status +
                ", remark=" + remark +
                ", gmtSpreadCreate=" + gmtSpreadCreate +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", delFlag=" + delFlag +
                "}";
	}
}
