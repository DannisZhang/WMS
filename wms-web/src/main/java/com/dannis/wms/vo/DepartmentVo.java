package com.dannis.wms.vo;

import java.util.Set;

/**
 * Created by:  deng.zhang
 * Created on:  2014-11-10 17:22
 */
public class DepartmentVo {
  /**
   * The id of entity
   */
  private int id;
  /**
   * The Chinese name of department
   */
  private String cnName;
  /**
   * The English name of department
   */
  private String enName;
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
  private String establishedDate;
  /**
   * The leader of department
   */
  private EmployeeVo manager;
  /**
   * The parent department
   */
  private DepartmentVo parent;
  /**
   * The sub-departments
   */
  private Set<DepartmentVo> children;
  /**
   * The remark of department
   */
  private String remark;
  /**
   * The status of department
   */
  private String status;
  /**
   * The time of creation
   */
  private String createdOn;
  /**
   * The id of creator
   */
  private int createdBy;
  /**
   * The time of modification
   */
  private String modifiedOn;
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

  public String getCnName() {
    return cnName;
  }

  public void setCnName(String cnName) {
    this.cnName = cnName;
  }

  public String getEnName() {
    return enName;
  }

  public void setEnName(String enName) {
    this.enName = enName;
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

  public String getEstablishedDate() {
    return establishedDate;
  }

  public void setEstablishedDate(String establishedDate) {
    this.establishedDate = establishedDate;
  }

  public EmployeeVo getManager() {
    return manager;
  }

  public void setManager(EmployeeVo manager) {
    this.manager = manager;
  }

  public DepartmentVo getParent() {
    return parent;
  }

  public void setParent(DepartmentVo parent) {
    this.parent = parent;
  }

  public Set<DepartmentVo> getChildren() {
    return children;
  }

  public void setChildren(Set<DepartmentVo> children) {
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

  public String getCreatedOn() {
    return createdOn;
  }

  public void setCreatedOn(String createdOn) {
    this.createdOn = createdOn;
  }

  public int getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(int createdBy) {
    this.createdBy = createdBy;
  }

  public String getModifiedOn() {
    return modifiedOn;
  }

  public void setModifiedOn(String modifiedOn) {
    this.modifiedOn = modifiedOn;
  }

  public int getModifiedBy() {
    return modifiedBy;
  }

  public void setModifiedBy(int modifiedBy) {
    this.modifiedBy = modifiedBy;
  }
}
