package com.dannis.wms.model;

import java.util.Date;

/**
 * 员工模型类
 *
 * Created by: Dannis
 * Created on: 2015-03-15 16:02
 */
public class Employee {
    /**
     * 员工姓名
     */
    private String name;
    /**
     * 员工编码
     */
    private String code;
    /**
     * 性别
     */
    private String gender;
    /**
     * 出生日期
     */
    private Date birthday;
    /**
     * 移动电话
     */
    private String mobilephone;
    /**
     * 办公电话
     */
    private String telephone;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 住址
     */
    private String address;
    /**
     * 所属部门
     */
    private Department department;
    /**
     * 职位
     */
    private Position position;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getMobilephone() {
        return mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
