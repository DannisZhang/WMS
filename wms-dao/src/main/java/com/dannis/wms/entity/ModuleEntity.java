package com.dannis.wms.entity;

/**
 * 系统模块实体类
 *
 * Created by: Dannis
 * Created on: 2015-03-15 16:41
 */
public class ModuleEntity extends BaseEntity {
    /**
     * 顺序
     */
    private Integer order;

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }
}
