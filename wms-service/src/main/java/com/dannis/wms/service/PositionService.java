package com.dannis.wms.service;

import com.dannis.wms.entity.Position;
import com.dannis.wms.query.QueryParams;
import com.dannis.wms.query.result.BaseResult;
import com.dannis.wms.query.result.PaginationQueryResult;
import com.dannis.wms.query.result.SingleQueryResult;

import java.util.Map;

/**
 * Created by:  deng.zhang
 * Created on:  2014-11-10 17:28
 */
public interface PositionService {
  /**
   * Add a position
   *
   * @param position position will be added
   * @return addition result
   */
  BaseResult addPosition(Position position);

  /**
   * Delete a position
   *
   * @param postId the position id which will be deleted
   * @return deletion result
   */
  BaseResult deletePosition(int postId);

  /**
   * Update a position
   *
   * @param position position will be updated
   * @return update result
   */
  BaseResult updatePosition(Position position);

  /**
   * Get a position according to specified id
   *
   * @param postId specified position id
   * @return which position id equals specified id
   */
  SingleQueryResult<Position> queryPosition(int postId);

  /**
   * Query position according to specified query parameters
   *
   * @param queryParams query parameters
   * @return those positions satisfied the query parameters
   */
  PaginationQueryResult<Position> queryPositions(QueryParams queryParams);
}
