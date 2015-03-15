package com.dannis.wms.entity;

import java.util.Date;

/**
 * 部门实体类
 *
 * Created by: Dannis
 * Created on: 2015-03-15 16:13
 */
public class DepartmentEntity extends BaseEntity {
    /**
     * 部门地址
     */
    private String location;
    /**
     * 成立时间
     */
    private Date establishedDate;
    /**
     * 管理员编码
     */
    private int managerCode;
    /**
     * 上级部门编码
     */
    private int parentCode;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getEstablishedDate() {
        return establishedDate;
    }

    public void setEstablishedDate(Date establishedDate) {
        this.establishedDate = establishedDate;
    }

    public int getManagerCode() {
        return managerCode;
    }

    public void setManagerCode(int managerCode) {
        this.managerCode = managerCode;
    }

    public int getParentCode() {
        return parentCode;
    }

    public void setParentCode(int parentCode) {
        this.parentCode = parentCode;
    }
}
