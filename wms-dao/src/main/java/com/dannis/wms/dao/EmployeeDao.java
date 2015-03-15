package com.dannis.wms.dao;

import com.dannis.wms.model.Employee;

import java.util.List;
import java.util.Map;

/**
 * Created by:  deng.zhang
 * Created on:  2014-11-10 17:54
 */
public interface EmployeeDao {
    /**
     * Add an employee
     *
     * @param employee employee will be added
     * @return true indicate added successful,false indicate failed
     */
    boolean addEmployee(Employee employee);

    /**
     * Delete an employee
     *
     * @param empId the employee id which will be deleted
     * @return true indicate deleted successful,false indicate failed
     */
    boolean deleteEmployee(int empId);

    /**
     * Update an employee
     *
     * @param employee employee will be updated
     * @return true indicate updated successful,false indicate failed
     */
    boolean updateEmployee(Employee employee);

    /**
     * Get an employee according to specified id
     *
     * @param empId specified employee id
     * @return which employee id equals specified id
     */
    Employee queryEmployee(int empId);

    /**
     * Query employee according to specified query parameters
     *
     * @param queryParams query parameters
     * @return those employees satisfied the query parameters
     */
    List<Employee> queryEmployees(Map<String, Object> queryParams);

    /**
     * Query the total number of employees according to specified query parameters
     *
     * @param queryParams query parameters
     * @return total number of employees
     */
    long getTotal(Map<String, Object> queryParams);
}
