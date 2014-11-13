package com.dannis.wms.po;

import com.dannis.wms.entity.BaseEntity;

/**
 * Created by:  deng.zhang
 * Created on:  2014-11-12 12:12
 */
public class PositionPo extends BaseEntity {
  /**
   * The code of position
   */
  private String code;
  /**
   * The remark of position
   */
  private String remark;
  /**
   * The status of position
   */
  private String status;

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

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
