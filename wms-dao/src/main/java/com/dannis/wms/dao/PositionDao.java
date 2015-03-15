package com.dannis.wms.dao;

import com.dannis.wms.model.Position;

import java.util.List;
import java.util.Map;

/**
 * Created by:  deng.zhang
 * Created on:  2014-11-10 17:53
 */
public interface PositionDao {
    /**
     * Add a position
     *
     * @param position position will be added
     * @return true indicate added successful,false indicate failed
     */
    boolean addPosition(Position position);

    /**
     * Delete a position
     *
     * @param postId the position id which will be deleted
     * @return true indicate deleted successful,false indicate failed
     */
    boolean deletePosition(int postId);

    /**
     * Update a position
     *
     * @param position position will be updated
     * @return true indicate updated successful,false indicate failed
     */
    boolean updatePosition(Position position);

    /**
     * Get a position according to specified id
     *
     * @param postId specified position id
     * @return which position id equals specified id
     */
    Position queryPosition(int postId);

    /**
     * Query position according to specified query parameters
     *
     * @param queryParams query parameters
     * @return those positions satisfied the query parameters
     */
    List<Position> queryPositions(Map<String, Object> queryParams);

    /**
     * Query the total number of positions according to specified query parameters
     *
     * @param queryParams query parameters
     * @return total number of positions
     */
    long getTotal(Map<String, Object> queryParams);
}
