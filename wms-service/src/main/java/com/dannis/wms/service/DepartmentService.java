package com.dannis.wms.service;

import com.dannis.wms.entity.Department;
import com.dannis.wms.query.QueryParams;
import com.dannis.wms.query.result.BaseResult;
import com.dannis.wms.query.result.PaginationQueryResult;
import com.dannis.wms.query.result.SingleQueryResult;

/**
 * Department service interface
 * <p>
 * Created by: Dannis
 * Created on: 2014-11-09 16:54
 */
public interface DepartmentService {
    /**
     * Add a department
     *
     * @param department department will be added
     * @return addition result
     */
    BaseResult addDepartment(Department department);

    /**
     * Delete a department
     *
     * @param deptId the department id which will be deleted
     * @return deletion result
     */
    BaseResult deleteDepartment(int deptId);

    /**
     * Update a department
     *
     * @param department department will be updated
     * @return update result
     */
    BaseResult updateDepartment(Department department);

    /**
     * Get a department according to specified id
     *
     * @param deptId specified department id
     * @return which department id equals specified id
     */
     SingleQueryResult<Department> queryDepartment(int deptId);

    /**
     * Query department according to specified query parameters
     *
     * @param queryParams query parameters
     * @return those departments satisfied the query parameters
     */
    PaginationQueryResult<Department> queryDepartments(QueryParams queryParams);
}