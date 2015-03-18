package com.dannis.wms.manager.impl;

import com.dannis.wms.common.constant.Constants;
import com.dannis.wms.dao.MenuDao;
import com.dannis.wms.entity.MenuEntity;
import com.dannis.wms.entity.utils.MenuUtil;
import com.dannis.wms.manager.MenuManager;
import com.dannis.wms.model.Menu;
import com.dannis.wms.query.QueryParams;
import com.dannis.wms.query.result.PaginationQueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author deng.zhang
 * @version 1.0.0
 * @since 2015-03-17 14:11
 */
@Component
public class MenuManagerImpl implements MenuManager {
    /**
     * 系统菜单DAO
     */
    @Autowired
    private MenuDao menuDao;

    @Override
    public void save(Menu menu) {
        MenuEntity entity = MenuUtil.convertToEntity(menu);
        entity.setStatus(Constants.STATUS_ACTIVE);
        entity.setModuleCode("009090");
        menuDao.save(entity);
    }

    @Override
    public void delete(String code) {
        menuDao.delete(code);
    }

    @Override
    public void deleteByCodes(List<String> codes) {
        menuDao.deleteByCodes(codes);
    }

    @Override
    public void deleteByModuleCode(String moduleCode) {
        menuDao.deleteByModuleCode(moduleCode);
    }

    @Override
    public Menu find(String code) {
        return MenuUtil.convertToModel(menuDao.find(code));
    }

    @Override
    public List<Menu> findByModuleCode(String moduleCode) {
        return MenuUtil.convertToModels(menuDao.findByModuleCode(moduleCode));
    }

    @Override
    public PaginationQueryResult<Menu> findByPage(QueryParams queryParams) {
        PaginationQueryResult<Menu> result = new PaginationQueryResult<>();
        if (null != queryParams) {
            result.setTotal(menuDao.getTotal(queryParams.getParams()));
            List<MenuEntity> menuEntities = menuDao.findByPage(queryParams.getOffset(), queryParams.getLimit(), queryParams.getParams());
            result.setRows(MenuUtil.convertToModels(menuEntities));
        }

        return result;
    }

    @Override
    public Long findMaxId() {
        return menuDao.findMaxId();
    }
}
