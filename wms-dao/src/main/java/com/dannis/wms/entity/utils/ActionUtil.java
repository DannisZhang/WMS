package com.dannis.wms.entity.utils;

import com.dannis.wms.entity.ActionEntity;
import com.dannis.wms.model.Action;

import java.util.ArrayList;
import java.util.List;

/**
 * @author deng.zhang
 * @version 1.0.0
 * @since 2015-03-17 11:16
 */
public class ActionUtil {
    /**
     * 将数据库实体对象转换成业务模型对象
     *
     * @param actionEntity 数据库实体对象
     * @return  业务模型对象
     */
    public static Action convertToModel(ActionEntity actionEntity) {
        Action action = null;
        if (actionEntity != null) {
            action = new Action();
            action.setCode(actionEntity.getCode());
            action.setName(actionEntity.getName());
            action.setUrl(actionEntity.getUrl());
            action.setRemark(actionEntity.getRemark());
        }
        return action;
    }

    /**
     * 将业务模型对象转换成数据库实体对象
     * @param action 业务模型对象
     * @return 数据库实体对象
     */
    public static ActionEntity convertToEntity(Action action) {
        ActionEntity actionEntity = null;
        if (action != null) {
            actionEntity = new ActionEntity();
            actionEntity.setName(action.getName());
            actionEntity.setUrl(action.getUrl());
            actionEntity.setCode(action.getCode());
            actionEntity.setRemark(action.getRemark());
        }
        return actionEntity;
    }

    public static List<Action> convertToModels(List<ActionEntity> actionEntities) {
        List<Action> actions = new ArrayList<>();
        if (null != actionEntities && actionEntities.size() > 0) {
            for (ActionEntity entity : actionEntities) {
                actions.add(convertToModel(entity));
            }
        }
        return actions;
    }
}
