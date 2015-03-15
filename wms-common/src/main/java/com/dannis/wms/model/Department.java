package com.dannis.wms.model;

import java.util.Date;
import java.util.Set;

/**
 * 部门模型类
 *
 * Created by: Dannis
 * Created on: 2015-03-15 15:52
 */
public class Department {
    /**
     * 部门名称
     */
    private String name;
    /**
     * 部门编码
     */
    private String code;
    /**
     * 部门地址
     */
    private String location;
    /**
     * 部门成立时间
     */
    private Date establishedDate;
    /**
     * 部门负责人
     */
    private Employee manager;
    /**
     * 上级部门
     */
    private Department parent;
    /**
     * 下级部门
     */
    private Set<Department> children;
    /**
     * 备注信息
     */
    private String remark;

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

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public Department getParent() {
        return parent;
    }

    public void setParent(Department parent) {
        this.parent = parent;
    }

    public Set<Department> getChildren() {
        return children;
    }

    public void setChildren(Set<Department> children) {
        this.children = children;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
