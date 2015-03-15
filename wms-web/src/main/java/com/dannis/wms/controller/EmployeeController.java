package com.dannis.wms.controller;

import com.dannis.wms.model.Employee;
import com.dannis.wms.query.QueryParams;
import com.dannis.wms.query.result.BaseResult;
import com.dannis.wms.query.result.PaginationQueryResult;
import com.dannis.wms.query.result.SingleQueryResult;
import com.dannis.wms.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by:  deng.zhang
 * Created on:  2014-11-11 15:36
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {
    /**
     * Employee service
     */
    @Autowired
    private EmployeeService employeeService;

    /**
     * Add an employee
     *
     * @param employee 员工
     * @return result
     */
    @RequestMapping(value = "/add.do")
    @ResponseBody
    public BaseResult addEmployee(Employee employee) {
        return employeeService.addEmployee(employee);
    }

    /**
     * Delete an employee according to id
     *
     * @param empId employee id
     * @return result
     */
    @RequestMapping(value = "/delete.do")
    @ResponseBody
    public BaseResult deleteEmployee(int empId) {
        return employeeService.deleteEmployee(empId);
    }

    /**
     * 修改员工信息
     *
     * @param employee 员工
     * @return result
     */
    @RequestMapping(value = "/update.do")
    @ResponseBody
    public BaseResult updateEmployee(Employee employee) {
        return employeeService.updateEmployee(employee);
    }

    /**
     * Query an employee which specified id
     *
     * @param empId employee id
     * @return result
     */
    @RequestMapping(value = "/queryById.do")
    @ResponseBody
    public SingleQueryResult<Employee> queryEmployeeById(int empId) {
        SingleQueryResult<Employee> result = new SingleQueryResult<>();
        SingleQueryResult<Employee> queryResult = employeeService.queryEmployee(empId);
        result.setCode(queryResult.getCode());
        result.setMessage(queryResult.getMessage());
        result.setData(queryResult.getData());

        return result;
    }

    /**
     * Query employees according to specified query parameters
     *
     * @param queryParams query parameters
     * @return result
     */
    @RequestMapping(value = "/queryByPage.do")
    @ResponseBody
    public PaginationQueryResult<Employee> queryEmployeeByPage(QueryParams queryParams) {
        PaginationQueryResult<Employee> result = new PaginationQueryResult<>();
        PaginationQueryResult<Employee> queryResult = employeeService.queryEmployees(queryParams);
        result.setCode(queryResult.getCode());
        result.setMessage(queryResult.getMessage());
        result.setTotal(queryResult.getTotal());
        result.setRows(queryResult.getRows());

        return result;
    }
}
