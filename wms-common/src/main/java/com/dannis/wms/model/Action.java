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
     * URL
     */
    private String url;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
