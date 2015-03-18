package com.dannis.wms.manager;

import com.dannis.wms.model.Action;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 系统菜单功能管理类
 *
 * @author deng.zhang
 * @version 1.0.0
 * @since 2015-03-17 11:10
 */
@Component
public interface ActionManager {
    /**
     * 保存菜单功能
     *
     * @param action 菜单功能实体对象
     */
    void save(Action action);

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
    Action find(String code);

    /**
     * 根据菜单编码查找菜单功能
     *
     * @param menuCode 菜单编码
     * @return 菜单功能列表
     */
    List<Action> findByMenuCode(String menuCode);
}
