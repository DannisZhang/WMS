package com.dannis.wms.dto;

/**
 * Department DTO
 * Created by:  deng.zhang
 * Created on:  2014-11-10 17:03
 */
public class DepartmentDto {
  /**
   * The id of department
   */
  protected int id;
  /**
   * The name of department
   */
  protected String name;
  /**
   * The code of department
   */
  private String code;
  /**
   * The manager's id of department
   */
  private int managerId;
  /**
   * The parent department
   */
  private int parentId;
  /**
   * The remark of department
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
}
