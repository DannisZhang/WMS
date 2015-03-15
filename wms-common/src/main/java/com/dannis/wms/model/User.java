package com.dannis.wms.model;

import java.util.List;

/**
 * 用户模型
 *
 * Created by: Dannis
 * Created on: 2015-03-15 16:54
 */
public class User {
    /**
     * 用户姓名
     */
    private String name;
    /**
     * 用户编码
     */
    private String code;
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
    /**
     * 角色列表
     */
    private List<Role> roles;
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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
