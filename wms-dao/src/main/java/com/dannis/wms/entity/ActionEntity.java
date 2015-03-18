package com.dannis.wms.entity;

/**
 * Created by: Dannis
 * Created on: 2015-03-15 16:29
 */
public class ActionEntity extends BaseEntity {
    /**
     * 功能值
     */
    private String url;
    /**
     * 菜单编码
     */
    private String menuCode;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }
}
