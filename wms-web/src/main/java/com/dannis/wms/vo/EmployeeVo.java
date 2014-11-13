package com.dannis.wms.vo;

import java.util.Date;

/**
 * Created by:  deng.zhang
 * Created on:  2014-11-10 20:11
 */
public class EmployeeVo {
  /**
   * The id of employee
   */
  private int id;
  /**
   * The name of employee
   */
  private String name;
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
   * The phone No. of employee
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
   * The department of employee belong to
   */
  private DepartmentVo department;
  /**
   * The position of employee
   */
  private PositionVo position;
  /**
   * The remark of employee
   */
  private String remark;
  /**
   * The time of creation
   */
  private Date createdOn;
  /**
   * The id of creator
   */
  private int createdBy;
  /**
   * The time of modification
   */
  private Date modifiedOn;
  /**
   * The id of modifier
   */
  private int modifiedBy;

  public int getId() {
    return id;
  }

  public void setId(int id) {
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

  public DepartmentVo getDepartment() {
    return department;
  }

  public void setDepartment(DepartmentVo department) {
    this.department = department;
  }

  public PositionVo getPosition() {
    return position;
  }

  public void setPosition(PositionVo position) {
    this.position = position;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public Date getCreatedOn() {
    return createdOn;
  }

  public void setCreatedOn(Date createdOn) {
    this.createdOn = createdOn;
  }

  public int getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(int createdBy) {
    this.createdBy = createdBy;
  }

  public Date getModifiedOn() {
    return modifiedOn;
  }

  public void setModifiedOn(Date modifiedOn) {
    this.modifiedOn = modifiedOn;
  }

  public int getModifiedBy() {
    return modifiedBy;
  }

  public void setModifiedBy(int modifiedBy) {
    this.modifiedBy = modifiedBy;
  }
}
