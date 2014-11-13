package com.dannis.wms.dto;

import java.util.Date;

/**
 * Employee DTO
 * Created by:  deng.zhang
 * Created on:  2014-11-10 20:11
 */
public class EmployeeDto {
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
   * The id of department
   */
  private int departmentId;
  /**
   * The id of position
   */
  private int positionId;
  /**
   * The remark of employee
   */
  private String remark;

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

  public int getDepartmentId() {
    return departmentId;
  }

  public void setDepartmentId(int departmentId) {
    this.departmentId = departmentId;
  }

  public int getPositionId() {
    return positionId;
  }

  public void setPositionId(int positionId) {
    this.positionId = positionId;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }
}
