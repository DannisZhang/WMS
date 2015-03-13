package com.dannis.wms.dto;

/**
 * Department DTO
 * Created by:  deng.zhang
 * Created on:  2014-11-10 17:03
 */
public class DepartmentDto {
    /**
     * The id of department
     */
    private String departmentId;
    /**
     * The Chinese name of department
     */
    private String cnName;
    /**
     * The English name of department
     */
    private String enName;
    /**
     * The code of department
     */
    private String code;
    /**
     * The location of department
     */
    private String location;
    /**
     * The date of department was established
     */
    private String establishedDate;
    /**
     * The manager's id of department
     */
    private int managerId;
    /**
     * The parent department
     */
    private int parentId;
    /**
     * The remark of department
     */
    private String remark;

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEstablishedDate() {
        return establishedDate;
    }

    public void setEstablishedDate(String establishedDate) {
        this.establishedDate = establishedDate;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
