package com.dannis.wms.po;

import com.dannis.wms.entity.BaseEntity;

import java.util.Date;

/**
 * Created by:  deng.zhang
 * Created on:  2014-11-12 12:11
 */
public class EmployeePo extends BaseEntity {
  /**
   * The code of employee
   */
  private String code;
  /**
   * The gender of employee
   */
  private String gender;
  /**
   * The age of employee
   */
  private int age;
  /**
   * The birthday of employee
   */
  private Date birthday;
  /**
   * The mobile phone No. of employee
   */
  private String mobilePhone;
  /**
   * The office phone No. of employee
   */
  private String officePhone;
  /**
   * The email address of employee
   */
  private String email;
  /**
   * The address of employee
   */
  private String address;
  /**
   * The remark of employee
   */
  private String remark;
  /**
   * The status of employee
   */
  private String status;

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

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public void setMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
  }

  public String getOfficePhone() {
    return officePhone;
  }

  public void setOfficePhone(String officePhone) {
    this.officePhone = officePhone;
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
