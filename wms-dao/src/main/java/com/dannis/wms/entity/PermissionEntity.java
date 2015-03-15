package com.dannis.wms.entity;

/**
 * 权限实体类
 *
 * Created by: Dannis
 * Created on: 2015-03-15 15:37
 */
public class PermissionEntity extends BaseEntity {
    /**
     * 模块编码
     */
    private String moduleCode;
    /**
     * 菜单编码
     */
    private String menuCode;
    /**
     * 功能编码
     */
    private String actionCode;

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getActionCode() {
        return actionCode;
    }

    public void setActionCode(String actionCode) {
        this.actionCode = actionCode;
    }
}
