package com.dannis.wms.dao;

import com.dannis.wms.entity.ActionEntity;

import java.util.List;

/**
 * 菜单功能DAO
 *
 * @author deng.zhang
 * @version 1.0.0
 * @since 2015-03-16 10:18
 */
public interface ActionDao {
    /**
     * 保存菜单功能
     *
     * @param action 菜单功能实体对象
     */
    void save(ActionEntity action);

    /**
     * 根据编码删除菜单功能
     *
     * @param code 菜单功能编码
     */
    void delete(String code);

    /**
     * 根据菜单编码删除菜单功能
     *
     * @param menuCode 菜单编码
     */
    void deleteByMenuCode(String menuCode);

    /**
     * 根据编码查找菜单功能
     *
     * @param code 菜单功能编码
     * @return 菜单功能实体对象
     */
    ActionEntity find(String code);

    /**
     * 根据菜单编码查找菜单功能
     *
     * @param menuCode 菜单编码
     * @return 菜单功能列表
     */
    List<ActionEntity> findByMenuCode(String menuCode);
}
