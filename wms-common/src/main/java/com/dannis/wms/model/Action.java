package com.dannis.wms.model;

/**
 * 菜单功能模型类
 *
 * Created by: Dannis
 * Created on: 2015-03-15 15:14
 */
public class Action {
    /**
     * 功能名称
     */
    private String name;
    /**
     * 功能编码
     */
    private String code;
    /**
     * 功能值
     */
    private String value;
    /**
     * 备注
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
