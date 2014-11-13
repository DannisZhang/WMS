package com.dannis.wms.controller;

import com.dannis.wms.dto.PositionDto;
import com.dannis.wms.entity.Position;
import com.dannis.wms.query.QueryParams;
import com.dannis.wms.query.result.BaseResult;
import com.dannis.wms.query.result.PaginationQueryResult;
import com.dannis.wms.query.result.SingleQueryResult;
import com.dannis.wms.service.PositionService;
import com.dannis.wms.vo.PositionVo;
import com.dannis.wms.web.utils.PositionWebUtil;
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
   * @param dto position DTO
   * @return result
   */
  @RequestMapping(value = "/add.do")
  @ResponseBody
  public BaseResult addPosition(PositionDto dto) {
    Position position = PositionWebUtil.convertToBo(dto);
    position.setCreatedBy(1);
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
   * @param dto position DTO
   * @return result
   */
  @RequestMapping(value = "/update.do")
  @ResponseBody
  public BaseResult updatePosition(PositionDto dto) {
    Position position = PositionWebUtil.convertToBo(dto);
    position.setModifiedBy(1);
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
  public SingleQueryResult<PositionVo> queryPositionById(int postId) {
    SingleQueryResult<PositionVo> result = new SingleQueryResult<>();
    SingleQueryResult<Position> queryResult = positionService.queryPosition(postId);
    result.setCode(queryResult.getCode());
    result.setMessage(queryResult.getMessage());
    result.setData(PositionWebUtil.convertToVo(queryResult.getData()));

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
  public PaginationQueryResult<PositionVo> queryPositionByPage(QueryParams queryParams) {
    PaginationQueryResult<PositionVo> result = new PaginationQueryResult<>();
    PaginationQueryResult<Position> queryResult = positionService.queryPositions(queryParams);
    result.setCode(queryResult.getCode());
    result.setMessage(queryResult.getMessage());
    result.setTotal(queryResult.getTotal());
    result.setRows(PositionWebUtil.convertToVos(queryResult.getRows()));

    return result;
  }
}
