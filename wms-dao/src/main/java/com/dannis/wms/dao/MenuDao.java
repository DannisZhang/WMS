package com.dannis.wms.dao;

import com.dannis.wms.entity.MenuEntity;

import java.util.List;
import java.util.Map;

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
     * @param menu 系统菜单实体对象
     */
    void save(MenuEntity menu);

    /**
     * 根据编码删除系统菜单
     *
     * @param code 系统菜单编码
     */
    void delete(String code);

    /**
     * 根据编码批量删除菜单
     *
     * @param codes 菜单编码列表
     */
    void deleteByCodes(List<String> codes);

    /**
     * 根据系统模块编码删除系统菜单
     *
     * @param moduleCode 系统模块编码
     */
    void deleteByModuleCode(String moduleCode);

    /**
     * 根据编码查询系统菜单
     *
     * @param code 系统菜单编码
     * @return 系统菜单实体对象
     */
    MenuEntity find(String code);

    /**
     * 根据系统模块编码查找系统菜单
     *
     * @param moduleCode 系统模块编码
     * @return 系统菜单列表
     */
    List<MenuEntity> findByModuleCode(String moduleCode);

    /**
     * 分页查询菜单
     *
     * @param start       查询开始
     * @param maxSize     每页大小
     * @param queryParams 查询参数
     * @return 菜单列表
     */
    List<MenuEntity> findByPage(int start, int maxSize, Map<String, String> queryParams);

    /**
     * 根据查询条件查询菜单总数
     *
     * @param queryParams 查询条件
     * @return 满足查询条件的菜单总数
     */
    long getTotal(Map<String, String> queryParams);

    /**
     * 查询最大ID值
     *
     * @return 最大ID值
     */
    long findMaxId();
}
