package com.dannis.wms.entity;

/**
 * 系统菜单实体类
 *
 * Created by: Dannis
 * Created on: 2015-03-15 16:34
 */
public class MenuEntity extends BaseEntity {
    /**
     * 菜单值
     */
    private String url;
    /**
     * 模块编码
     */
    private String moduleCode;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }
}
