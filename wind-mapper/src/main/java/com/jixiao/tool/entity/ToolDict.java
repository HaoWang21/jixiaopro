package com.jixiao.tool.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 字典
 * </p>
 *
 * @author jiang
 * @since 2018-09-28
 */
public class ToolDict implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 标签
     */
    private String label;
    /**
     * 值
     */
    private String value;
    /**
     * 图标
     */
    private String icon;
    /**
     * 排序
     */
    private Integer seq;
    /**
     * 上级Id
     */
    private Long parentId;
    /**
     * 是否可编辑：1是 0否
     */
    private Boolean editable;
    /**
     * 是否启用：1是 0否
     */
    private Boolean enable;
    /**
     * 备注
     */
    private String remark;
    /**
     * 创建人Id
     */
    private Long createSysUserId;
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


    public ToolDict() {

    }

    private ToolDict(Builder builder) {
        this.id = builder.id;
        this.label = builder.label;
        this.value = builder.value;
        this.icon = builder.icon;
        this.seq = builder.seq;
        this.parentId = builder.parentId;
        this.editable = builder.editable;
        this.enable = builder.enable;
        this.remark = builder.remark;
        this.createSysUserId = builder.createSysUserId;
        this.gmtCreate = builder.gmtCreate;
        this.gmtModified = builder.gmtModified;
        this.delFlag = builder.delFlag;
    }


    public static class Builder {

        private Long id;
        private String label;
        private String value;
        private String icon;
        private Integer seq;
        private Long parentId;
        private Boolean editable;
        private Boolean enable;
        private String remark;
        private Long createSysUserId;
        private Date gmtCreate;
        private Date gmtModified;
        private Boolean delFlag;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder label(String label) {
            this.label = label;
            return this;
        }

        public Builder value(String value) {
            this.value = value;
            return this;
        }

        public Builder icon(String icon) {
            this.icon = icon;
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

        public Builder editable(Boolean editable) {
            this.editable = editable;
            return this;
        }

        public Builder enable(Boolean enable) {
            this.enable = enable;
            return this;
        }

        public Builder remark(String remark) {
            this.remark = remark;
            return this;
        }

        public Builder createSysUserId(Long createSysUserId) {
            this.createSysUserId = createSysUserId;
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

        public ToolDict build() {
            return new ToolDict(this);
        }
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
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

    public Boolean getEditable() {
        return editable;
    }

    public void setEditable(Boolean editable) {
        this.editable = editable;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getCreateSysUserId() {
        return createSysUserId;
    }

    public void setCreateSysUserId(Long createSysUserId) {
        this.createSysUserId = createSysUserId;
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
        return "ToolDict{" +
                "id=" + id +
                ", label=" + label +
                ", value=" + value +
                ", icon=" + icon +
                ", seq=" + seq +
                ", parentId=" + parentId +
                ", editable=" + editable +
                ", enable=" + enable +
                ", remark=" + remark +
                ", createSysUserId=" + createSysUserId +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", delFlag=" + delFlag +
                "}";
    }
}
