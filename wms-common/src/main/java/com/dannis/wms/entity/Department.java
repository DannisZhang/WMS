package com.dannis.wms.entity;

import com.dannis.wms.common.constant.Constants;

import java.util.Set;

/**
 * Department entity class
 *
 * Created by: Dannis
 * Created on: 2014-11-09 13:50
 */
public class Department extends BaseEntity {
    /**
     * The code of department
     */
    private String code;
    /**
     * The leader of department
     */
    private Employee manager;
    /**
     * The parent department
     */
    private Department parent;
    /**
     * The sub-departments
     */
    private Set<Department> children;
    /**
     * The remark of department
     */
    private String remark;
    /**
     * The status of department
     */
    private String status = Constants.STATUS_ACTIVE;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee leader) {
        this.manager = leader;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}