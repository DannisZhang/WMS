package com.dannis.wms.entity;

import java.util.Date;

/**
 * 基本实体类
 *
 * Created by: Dannis
 * Created on: 2015-03-15 15:38
 */
public class BaseEntity {
    /**
     * 实体ID
     */
    private Long id;
    /**
     * 实体名称
     */
    private String name;
    /**
     * 实体编码
     */
    private String code;
    /**
     * 创建者
     */
    private Long createdBy;
    /**
     * 创建时间
     */
    private Date createdOn;
    /**
     * 最近修改者
     */
    private Long lastModifiedBy;
    /**
     * 最近修改时间
     */
    private Date lastModifiedOn;
    /**
     * 备注信息
     */
    private String remark;
    /**
     * 状态
     */
    private String status;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Long getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(Long lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Date getLastModifiedOn() {
        return lastModifiedOn;
    }

    public void setLastModifiedOn(Date lastModifiedOn) {
        this.lastModifiedOn = lastModifiedOn;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
