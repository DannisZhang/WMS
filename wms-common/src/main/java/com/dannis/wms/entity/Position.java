package com.dannis.wms.entity;

import com.dannis.wms.common.constant.Constants;

/**
 * Created by: Dannis
 * Created on: 2014-11-09 14:20
 */
public class Position extends BaseEntity {
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
    private String status = Constants.STATUS_ACTIVE;

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
