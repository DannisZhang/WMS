package com.dannis.wms.po;

import com.dannis.wms.entity.BaseEntity;

import java.util.Date;

/**
 * Created by:  deng.zhang
 * Created on:  2014-11-12 12:11
 */
public class DepartmentPo extends BaseEntity {
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
  private Date establishedDate;
  /**
   * The id of manager id
   */
  private int managerId;
  /**
   * The id of parent department
   */
  private int parentId;
  /**
   * The remark of department
   */
  private String remark;
  /**
   * The status of department
   */
  private String status;

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

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
