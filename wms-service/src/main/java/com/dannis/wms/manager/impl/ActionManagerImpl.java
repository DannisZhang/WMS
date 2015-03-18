package com.dannis.wms.manager.impl;

import com.dannis.wms.common.constant.Constants;
import com.dannis.wms.dao.ActionDao;
import com.dannis.wms.entity.ActionEntity;
import com.dannis.wms.entity.utils.ActionUtil;
import com.dannis.wms.manager.ActionManager;
import com.dannis.wms.model.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author deng.zhang
 * @version 1.0.0
 * @since 2015-03-17 11:14
 */
@Component
public class ActionManagerImpl implements ActionManager {
    /**
     * 系统菜单功能DAO
     */
    @Autowired
    private ActionDao actionDao;

    @Override
    public void save(Action action) {
        ActionEntity actionEntity = ActionUtil.convertToEntity(action);
        actionEntity.setMenuCode("0000");
        actionEntity.setStatus(Constants.STATUS_ACTIVE);
        actionDao.save(actionEntity);
    }

    @Override
    public void delete(String code) {
        actionDao.delete(code);
    }

    @Override
    public void deleteByMenuCode(String menuCode) {
        actionDao.deleteByMenuCode(menuCode);
    }

    @Override
    public Action find(String code) {
        return ActionUtil.convertToModel(actionDao.find(code));
    }

    @Override
    public List<Action> findByMenuCode(String menuCode) {
        return ActionUtil.convertToModels(actionDao.findByMenuCode(menuCode));
    }
}
