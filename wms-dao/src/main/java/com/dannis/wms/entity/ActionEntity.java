package com.dannis.wms.entity;

/**
 * Created by: Dannis
 * Created on: 2015-03-15 16:29
 */
public class ActionEntity extends BaseEntity {
    /**
     * 功能值
     */
    private String value;
    /**
     * 菜单编码
     */
    private Long menuCode;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Long getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(Long menuCode) {
        this.menuCode = menuCode;
    }
}
