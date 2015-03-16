package com.dannis.wms.dao;

import com.dannis.wms.entity.RoleEntity;

import java.util.List;

/**
 * 角色DAO
 *
 * @author deng.zhang
 * @version 1.0.0
 * @since 2015-03-16 10:19
 */
public interface RoleDao {
    /**
     * 保存角色
     *
     * @param role 角色实体对象
     */
    void save(RoleEntity role);

    /**
     * 根据编码删除角色
     *
     * @param code 角色编码
     */
    void delete(String code);

    /**
     * 根据编码查找角色
     *
     * @param code 角色编码
     * @return 角色实体对象
     */
    RoleEntity find(String code);

    /**
     * 根据用户编码查找角色
     *
     * @param userCode 用户编码
     * @return 角色列表
     */
    List<RoleEntity> findByUserCode(String userCode);
}
