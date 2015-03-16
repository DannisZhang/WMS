package com.dannis.wms.dao;

import com.dannis.wms.entity.ModuleEntity;

/**
 * 系统模块DAO
 *
 * @author deng.zhang
 * @version 1.0.0
 * @since 2015-03-16 10:18
 */
public interface ModuleDao {
    /**
     * 保存系统模块
     *
     * @param module 系统模块实体对象
     */
    void save(ModuleEntity module);

    /**
     * 根据编码删除系统模块
     *
     * @param code 系统模块编码
     */
    void delete(String code);

    /**
     * 根据编码查找系统模块
     *
     * @param code 系统模块编码
     * @return  系统模块实体对象
     */
    ModuleEntity find(String code);
}
