package com.dannis.wms.vo;

import java.util.Date;

/**
 * Created by:  deng.zhang
 * Created on:  2014-11-10 20:11
 */
public class PositionVo {
  /**
   * The id of entity
   */
  private int id;
  /**
   * The name of entity
   */
  private String name;
  /**
   * The code of position
   */
  private String code;
  /**
   * The remark of position
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
