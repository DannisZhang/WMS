package com.dannis.wms.entity;

import java.util.Date;

/**
 * 员工实体类
 *
 * Created by: Dannis
 * Created on: 2015-03-15 16:19
 */
public class EmployeeEntity extends BaseEntity {
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
}
