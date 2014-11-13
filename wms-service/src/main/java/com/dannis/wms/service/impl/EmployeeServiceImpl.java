package com.dannis.wms.service.impl;

import com.dannis.wms.dao.EmployeeDao;
import com.dannis.wms.entity.Employee;
import com.dannis.wms.query.QueryParams;
import com.dannis.wms.query.result.BaseResult;
import com.dannis.wms.query.result.PaginationQueryResult;
import com.dannis.wms.query.result.SingleQueryResult;
import com.dannis.wms.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by:  deng.zhang
 * Created on:  2014-11-11 14:03
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
  /**
   * Employee DAO
   */
  @Autowired
  private EmployeeDao employeeDao;
  @Override
  public BaseResult addEmployee(Employee employee) {
    return null;
  }

  @Override
  public BaseResult deleteEmployee(int empId) {
    return null;
  }

  @Override
  public BaseResult updateEmployee(Employee employee) {
    return null;
  }

  @Override
  public SingleQueryResult<Employee> queryEmployee(int empId) {
    return null;
  }

  @Override
  public PaginationQueryResult<Employee> queryEmployees(QueryParams queryParams) {
    return null;
  }
}
