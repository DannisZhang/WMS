package com.dannis.wms.controller;

import com.dannis.wms.model.Position;
import com.dannis.wms.query.QueryParams;
import com.dannis.wms.query.result.BaseResult;
import com.dannis.wms.query.result.PaginationQueryResult;
import com.dannis.wms.query.result.SingleQueryResult;
import com.dannis.wms.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by:  deng.zhang
 * Created on:  2014-11-11 15:36
 */
@Controller
@RequestMapping("/position")
public class PositionController {
    /**
     * Position service
     */
    @Autowired
    private PositionService positionService;

    /**
     * Add a position
     *
     * @param position 职位
     * @return result
     */
    @RequestMapping(value = "/add.do")
    @ResponseBody
    public BaseResult addPosition(Position position) {
        return positionService.addPosition(position);
    }

    /**
     * Delete a position which specified id
     *
     * @param postId position id
     * @return result
     */
    @RequestMapping(value = "/delete.do")
    @ResponseBody
    public BaseResult deletePosition(int postId) {
        return positionService.deletePosition(postId);
    }

    /**
     * Update position
     *
     * @param position 职位
     * @return result
     */
    @RequestMapping(value = "/update.do")
    @ResponseBody
    public BaseResult updatePosition(Position position) {
        return positionService.updatePosition(position);
    }

    /**
     * Query a position according to id
     *
     * @param postId position id
     * @return result
     */
    @RequestMapping(value = "/queryById.do")
    @ResponseBody
    public SingleQueryResult<Position> queryPositionById(int postId) {
        SingleQueryResult<Position> result = new SingleQueryResult<>();
        SingleQueryResult<Position> queryResult = positionService.queryPosition(postId);
        result.setCode(queryResult.getCode());
        result.setMessage(queryResult.getMessage());
        result.setData(queryResult.getData());

        return result;
    }

    /**
     * Query positions according to specified query parameters
     *
     * @param queryParams query parameters
     * @return result
     */
    @RequestMapping(value = "/queryByPage.do")
    @ResponseBody
    public PaginationQueryResult<Position> queryPositionByPage(QueryParams queryParams) {
        PaginationQueryResult<Position> result = new PaginationQueryResult<>();
        PaginationQueryResult<Position> queryResult = positionService.queryPositions(queryParams);
        result.setCode(queryResult.getCode());
        result.setMessage(queryResult.getMessage());
        result.setTotal(queryResult.getTotal());
        result.setRows(queryResult.getRows());

        return result;
    }
}
