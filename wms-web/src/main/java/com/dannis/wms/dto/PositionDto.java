package com.dannis.wms.dto;

/**
 * Position DTO
 * Created by:  deng.zhang
 * Created on:  2014-11-10 20:12
 */
public class PositionDto {
  /**
   * The id of position
   */
  private int id;
  /**
   * The name of position
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
}
