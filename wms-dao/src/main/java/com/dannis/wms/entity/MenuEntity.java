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
    private String value;
    /**
     * 模块编码
     */
    private Long moduleCode;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Long getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(Long moduleCode) {
        this.moduleCode = moduleCode;
    }
}
