package com.dannis.wms.entity;

/**
 * 用户实体类
 *
 * Created by: Dannis
 * Created on: 2015-03-15 17:04
 */
public class UserEntity extends BaseEntity {
    /**
     * 登陆名称
     */
    private String loginName;
    /**
     * 性别
     */
    private String gender;
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

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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
}
