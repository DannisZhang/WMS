package com.dannis.wms.model;

import java.util.List;

/**
 * 系统功能模块模型类
 *
 * Created by: Dannis
 * Created on: 2015-03-15 15:25
 */
public class Module {
    /**
     * 模块名称
     */
    private String name;
    /**
     * 模块编码
     */
    private String code;
    /**
     * 顺序
     */
    private Integer order;
    /**
     * 菜单列表
     */
    private List<Menu> menus;
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

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
