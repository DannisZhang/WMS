package com.dannis.wms.service;

import com.dannis.wms.model.Employee;
import com.dannis.wms.query.QueryParams;
import com.dannis.wms.query.result.BaseResult;
import com.dannis.wms.query.result.PaginationQueryResult;
import com.dannis.wms.query.result.SingleQueryResult;

/**
 * Employee service class
 * Created by:  deng.zhang
 * Created on:  2014-11-10 17:28
 */
public interface EmployeeService {
    /**
     * Add an employee
     *
     * @param employee employee will be added
     * @return addition result
     */
    BaseResult addEmployee(Employee employee);

    /**
     * Delete an employee
     *
     * @param empId the employee id which will be deleted
     * @return deletion result
     */
    BaseResult deleteEmployee(int empId);

    /**
     * Update an employee
     *
     * @param employee employee will be updated
     * @return update result
     */
    BaseResult updateEmployee(Employee employee);

    /**
     * Get an employee according to specified id
     *
     * @param empId specified employee id
     * @return which employee id equals specified id
     */
    SingleQueryResult<Employee> queryEmployee(int empId);

    /**
     * Query employee according to specified query parameters
     *
     * @param queryParams query parameters
     * @return those employees satisfied the query parameters
     */
    PaginationQueryResult<Employee> queryEmployees(QueryParams queryParams);
}
