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
     * 添加菜单功能
     *
     * @param actionEntity 菜单功能实体对象
     */
    void add(ActionEntity actionEntity);

    /**
     * 根据ID删除菜单功能
     *
     * @param id 菜单功能ID
     */
    void delete(Long id);

    /**
     * 根据菜单编码删除菜单功能
     *
     * @param menuCode 菜单编码
     */
    void deleteByMenuCode(String menuCode);

    /**
     * 更新菜单功能信息
     *
     * @param actionEntity 菜单功能实体对象
     */
    void update(ActionEntity actionEntity);

    /**
     * 根据ID查找菜单功能
     *
     * @param id 菜单功能ID
     * @return 菜单功能实体对象
     */
    ActionEntity find(Long id);

    /**
     * 根据菜单编码查找菜单功能
     *
     * @param menuCode 菜单编码
     * @return 菜单功能列表
     */
    List<ActionEntity> findByMenuCode(String menuCode);
}
