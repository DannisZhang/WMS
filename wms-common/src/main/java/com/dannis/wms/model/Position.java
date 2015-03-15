package com.dannis.wms.model;

/**
 * 职位模型
 *
 * Created by: Dannis
 * Created on: 2015-03-15 16:05
 */
public class Position {
    /**
     * 职位名称
     */
    private String name;
    /**
     * 职位编码
     */
    private String code;
    /**
     * 备注信息
     */
    private String remark;

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
