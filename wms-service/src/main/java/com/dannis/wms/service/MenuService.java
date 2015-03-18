package com.dannis.wms.service;

import com.dannis.wms.model.Menu;
import com.dannis.wms.query.QueryParams;
import com.dannis.wms.query.result.PaginationQueryResult;

import java.util.List;

/**
 * 系统菜单服务类
 *
 * @author deng.zhang
 * @version 1.0.0
 * @since 2015-03-17 11:26
 */
public interface MenuService {
    /**
     * 保存系统菜单（新增或修改）
     *
     * @param menu 系统菜单实体对象
     */
    void save(Menu menu);

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
    Menu find(String code);

    /**
     * 根据系统模块编码查找系统菜单
     *
     * @param moduleCode 系统模块编码
     * @return 系统菜单列表
     */
    List<Menu> findByModuleCode(String moduleCode);

    /**
     * 分页查询菜单
     *
     * @param queryParams 查询参数
     * @return 查询结果
     */
    PaginationQueryResult<Menu> findByPage(QueryParams queryParams);
}
