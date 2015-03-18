package com.dannis.wms.dao;

import com.dannis.wms.entity.UserEntity;

/**
 * 用户DAO
 *
 * @author deng.zhang
 * @version 1.0.0
 * @since 2015-03-16 10:19
 */
public interface UserDao {
    /**
     * 保存用户
     *
     * @param user 用户实体对象
     */
    void save(UserEntity user);

    /**
     * 根据编码删除用户信息
     *
     * @param code 用户编码
     */
    void delete(String code);

    /**
     * 根据编码查找用户
     *
     * @param code 用户编码
     * @return 用户实体对象
     */
    UserEntity find(String code);
}
