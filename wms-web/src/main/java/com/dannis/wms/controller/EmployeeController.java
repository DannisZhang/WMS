package com.dannis.wms.controller;

import com.dannis.wms.dto.EmployeeDto;
import com.dannis.wms.entity.Employee;
import com.dannis.wms.query.QueryParams;
import com.dannis.wms.query.result.BaseResult;
import com.dannis.wms.query.result.PaginationQueryResult;
import com.dannis.wms.query.result.SingleQueryResult;
import com.dannis.wms.service.EmployeeService;
import com.dannis.wms.vo.EmployeeVo;
import com.dannis.wms.web.utils.EmployeeWebUtil;
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
   * @param dto employee DTO
   * @return result
   */
  @RequestMapping(value = "/add.do")
  @ResponseBody
  public BaseResult addEmployee(EmployeeDto dto) {
    Employee employee = EmployeeWebUtil.convertToBo(dto);
    employee.setCreatedBy(1);
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
   * Update an employee
   *
   * @param dto employee DTO
   * @return result
   */
  @RequestMapping(value = "/update.do")
  @ResponseBody
  public BaseResult updateEmployee(EmployeeDto dto) {
    Employee employee = EmployeeWebUtil.convertToBo(dto);
    employee.setModifiedBy(1);
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
  public SingleQueryResult<EmployeeVo> queryEmployeeById(int empId) {
    SingleQueryResult<EmployeeVo> result = new SingleQueryResult<>();
    SingleQueryResult<Employee> queryResult = employeeService.queryEmployee(empId);
    result.setCode(queryResult.getCode());
    result.setMessage(queryResult.getMessage());
    result.setData(EmployeeWebUtil.convertToVo(queryResult.getData()));

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
  public PaginationQueryResult<EmployeeVo> queryEmployeeByPage(QueryParams queryParams) {
    PaginationQueryResult<EmployeeVo> result = new PaginationQueryResult<>();
    PaginationQueryResult<Employee> queryResult = employeeService.queryEmployees(queryParams);
    result.setCode(queryResult.getCode());
    result.setMessage(queryResult.getMessage());
    result.setTotal(queryResult.getTotal());
    result.setRows(EmployeeWebUtil.convertToVos(queryResult.getRows()));

    return result;
  }
}
