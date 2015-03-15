package com.dannis.wms.service.impl;

import com.dannis.wms.dao.PositionDao;
import com.dannis.wms.model.Position;
import com.dannis.wms.query.QueryParams;
import com.dannis.wms.query.result.BaseResult;
import com.dannis.wms.query.result.PaginationQueryResult;
import com.dannis.wms.query.result.SingleQueryResult;
import com.dannis.wms.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by:  deng.zhang
 * Created on:  2014-11-11 14:03
 */
@Service
public class PositionServiceImpl implements PositionService {
    /**
     * Position DAO
     */
    @Autowired
    private PositionDao positionDao;

    @Override
    public BaseResult addPosition(Position position) {
        return null;
    }

    @Override
    public BaseResult deletePosition(int postId) {
        return null;
    }

    @Override
    public BaseResult updatePosition(Position position) {
        return null;
    }

    @Override
    public SingleQueryResult<Position> queryPosition(int postId) {
        return null;
    }

    @Override
    public PaginationQueryResult<Position> queryPositions(QueryParams queryParams) {
        return null;
    }
}
