package com.dannis.wms.service.impl;

import com.dannis.wms.manager.MenuManager;
import com.dannis.wms.model.Menu;
import com.dannis.wms.query.QueryParams;
import com.dannis.wms.query.result.PaginationQueryResult;
import com.dannis.wms.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author deng.zhang
 * @version 1.0.0
 * @since 2015-03-17 11:27
 */
@Component
public class MenuServiceImpl implements MenuService {
    /**
     * 系统菜单管理类
     */
    @Autowired
    private MenuManager menuManager;

    @Override
    public void save(Menu menu) {
        Long maxMenuId = menuManager.findMaxId();
        String code = "menu" + maxMenuId;
        menu.setCode(code);
        menuManager.save(menu);
    }

    @Override
    public void delete(String code) {
        menuManager.delete(code);
    }

    @Override
    public void deleteByCodes(List<String> codes) {
        menuManager.deleteByCodes(codes);
    }

    @Override
    public void deleteByModuleCode(String moduleCode) {
        menuManager.deleteByModuleCode(moduleCode);
    }

    @Override
    public Menu find(String code) {
        return menuManager.find(code);
    }

    @Override
    public List<Menu> findByModuleCode(String moduleCode) {
        return menuManager.findByModuleCode(moduleCode);
    }

    @Override
    public PaginationQueryResult<Menu> findByPage(QueryParams queryParams) {
        return menuManager.findByPage(queryParams);
    }
}
