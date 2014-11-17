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
   * Delete a department
   *
   * @param deptId the department id which will be deleted
   * @return true indicate deleted successful,false indicate failed
   */
  boolean deleteDepartment(int deptId);

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
  List queryDepartments(Map<String, Object> queryParams);

  /**
   * Query department by page
   * @param pageNo page number
   * @param pageSize page size
   * @param queryParams query parameters
   * @return department list
   */
  List<DepartmentPo> queryDepartmentByPage(int pageNo,int pageSize,Map<String,String> queryParams);

  /**
   * Query the total number of departments according to specified query parameters
   * @param queryParams query parameters
   * @return total number of departments
   */
  long getTotal(Map<String, Object> queryParams);
}
