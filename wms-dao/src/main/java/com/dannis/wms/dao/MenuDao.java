package com.dannis.wms.dao;

import com.dannis.wms.entity.MenuEntity;

import java.util.List;

/**
 * 系统菜单DAO
 *
 * @author deng.zhang
 * @version 1.0.0
 * @since 2015-03-16 10:18
 */
public interface MenuDao {
    /**
     * 保存系统菜单（新增或修改）
     *
     * @param menuEntity 系统菜单实体对象
     */
    void save(MenuEntity menuEntity);

    /**
     * 根据编码删除系统菜单
     *
     * @param menuCode 系统菜单编码
     */
    void delete(String menuCode);

    /**
     * 根据系统模块编码删除系统菜单
     *
     * @param moduleCode 系统模块编码
     */
    void deleteByModuleCode(String moduleCode);

    /**
     * 根据编码查询系统菜单
     *
     * @param menuCode 系统菜单编码
     * @return 系统菜单实体对象
     */
    MenuEntity find(String menuCode);

    /**
     * 根据系统模块编码查找系统菜单
     *
     * @param moduleCode 系统模块编码
     * @return 系统菜单列表
     */
    List<MenuEntity> findByModuleCode(String moduleCode);
}
