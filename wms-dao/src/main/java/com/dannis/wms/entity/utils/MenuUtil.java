package com.dannis.wms.entity.utils;

import com.dannis.wms.entity.MenuEntity;
import com.dannis.wms.model.Menu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author deng.zhang
 * @version 1.0.0
 * @since 2015-03-17 14:12
 */
public class MenuUtil {
    /**
     * 将数据库实体对象转换成业务模型对象
     *
     * @param menuEntity 数据库实体对象
     * @return  业务模型对象
     */
    public static Menu convertToModel(MenuEntity menuEntity) {
        Menu menu = null;
        if (menuEntity != null) {
            menu = new Menu();
            menu.setName(menuEntity.getName());
            menu.setCode(menuEntity.getCode());
            menu.setUrl(menuEntity.getUrl());
            menu.setRemark(menuEntity.getRemark());
        }
        return menu;
    }

    /**
     * 将业务模型对象转换成数据库实体对象
     * @param menu 业务模型对象
     * @return 数据库实体对象
     */
    public static MenuEntity convertToEntity(Menu menu) {
        MenuEntity menuEntity = null;
        if (menu != null) {
            menuEntity = new MenuEntity();
            menuEntity.setName(menu.getName());
            menuEntity.setCode(menu.getCode());
            menuEntity.setUrl(menu.getUrl());
            menuEntity.setRemark(menu.getRemark());
        }
        return menuEntity;
    }

    public static List<Menu> convertToModels(List<MenuEntity> actionEntities) {
        List<Menu> actions = new ArrayList<>();
        if (null != actionEntities && actionEntities.size() > 0) {
            for (MenuEntity entity : actionEntities) {
                actions.add(convertToModel(entity));
            }
        }
        return actions;
    }
}
