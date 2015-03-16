package com.dannis.wms.dao;

import com.dannis.wms.entity.PermissionEntity;

import java.util.List;

/**
 * 权限DAO
 *
 * @author deng.zhang
 * @version 1.0.0
 * @since 2015-03-16 10:19
 */
public interface PermissionDao {
    /**
     * 保存权限
     *
     * @param permission 权限实体对象
     */
    void save(PermissionEntity permission);

    /**
     * 根据编码删除权限
     *
     * @param code 权限编码
     */
    void delete(String code);

    /**
     * 根据编码查找权限
     *
     * @param code 权限编码
     * @return 权限实体对象
     */
    PermissionEntity find(String code);

    /**
     * 根据角色编码查找权限
     *
     * @param roleCode 角色编码
     * @return 权限列表
     */
    List<PermissionEntity> findByRoleCode(String roleCode);
}
