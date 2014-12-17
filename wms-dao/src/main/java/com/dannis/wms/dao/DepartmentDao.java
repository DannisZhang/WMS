package com.dannis.wms.dao;

import com.dannis.wms.po.DepartmentPo;

import java.util.List;
import java.util.Map;

/**
 * Created by:  deng.zhang
 * Created on:  2014-11-10 16:00
 */
public interface DepartmentDao {
  /**
   * Add a department
   *
   * @param department department will be added
   * @return true indicate added successful,false indicate failed
   */
  boolean addDepartment(DepartmentPo department);

  /**
   * Delete a department which id equals the specified id
   *
   * @param deptId specified id
   * @return true indicate deleted successful,false indicate failed
   */
  boolean deleteDepartmentById(int deptId);

  /**
   * Delete departments those id equal the specified id list
   *
   * @param ids id list
   * @return result
   */
  boolean deleteDepartmentsByIds(int[] ids);

  /**
   * Update a department
   *
   * @param department department will be updated
   * @return true indicate updated successful,false indicate failed
   */
  boolean updateDepartment(DepartmentPo department);

  /**
   * Get a department according to specified id
   *
   * @param deptId specified department id
   * @return which department id equals specified id
   */
  DepartmentPo queryDepartment(int deptId);

  /**
   * Query department according to specified query parameters
   *
   * @param queryParams query parameters
   * @return those departments satisfied with the query parameters
   */
  List queryDepartments(Map<String, String> queryParams);

  /**
   * Query department by page
   * @param start start position
   * @param maxSize max result size
   * @param queryParams query parameters
   * @return department list
   */
  List<DepartmentPo> queryDepartmentByPage(int start, int maxSize, Map<String, String> queryParams);

  /**
   * Query the total number of departments according to specified query parameters
   * @param queryParams query parameters
   * @return total number of departments
   */
  long getTotal(Map<String, String> queryParams);

  /**
   * Retrieve the max id of department
   * @return max id of department
   */
  long getMaxId();
}
