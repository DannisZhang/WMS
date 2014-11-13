package com.dannis.wms.web.utils;

import com.dannis.wms.dto.EmployeeDto;
import com.dannis.wms.entity.Department;
import com.dannis.wms.entity.Employee;
import com.dannis.wms.entity.Position;
import com.dannis.wms.vo.EmployeeVo;

import java.util.ArrayList;
import java.util.List;

/**
 * Employee utility,used to convert Employee DTO to BO and BO to VO
 * Created by:  deng.zhang
 * Created on:  2014-11-10 22:44
 */
public class EmployeeWebUtil {
  /**
   * Convert Employee DTO to BO
   *
   * @param dto Employee DTO
   * @return Employee BO
   */
  public static Employee convertToBo(EmployeeDto dto) {
    Employee employee = new Employee();
    employee.setId(dto.getId());
    employee.setName(dto.getName());
    employee.setCode(dto.getCode());
    employee.setAddress(dto.getAddress());
    employee.setAge(dto.getAge());
    employee.setBirthday(dto.getBirthday());
    employee.setGender(dto.getGender());
    employee.setMobilePhone(dto.getMobilePhone());
    employee.setOfficePhone(dto.getOfficePhone());
    employee.setEmail(dto.getEmail());

    Department department = new Department();
    department.setId(dto.getDepartmentId());
    employee.setDepartment(department);

    Position position = new Position();
    position.setId(dto.getPositionId());
    employee.setPosition(position);

    return employee;
  }

  /**
   * Convert Employee BO to VO
   *
   * @param employee Employee BO
   * @return Employee VO
   */
  public static EmployeeVo convertToVo(Employee employee) {
    EmployeeVo vo = new EmployeeVo();
    vo.setId(employee.getId());
    vo.setName(employee.getName());
    vo.setAge(employee.getAge());
    vo.setGender(employee.getGender());
    vo.setMobilePhone(employee.getMobilePhone());
    vo.setOfficePhone(employee.getOfficePhone());
    vo.setEmail(employee.getEmail());
    vo.setCode(employee.getCode());
    vo.setRemark(employee.getRemark());
    vo.setAddress(employee.getAddress());
    vo.setBirthday(employee.getBirthday());
    vo.setCreatedOn(employee.getCreatedOn());
    vo.setCreatedBy(employee.getCreatedBy());
    vo.setModifiedOn(employee.getModifiedOn());
    vo.setModifiedBy(employee.getModifiedBy());

    return vo;
  }

  /**
   * Convert employeesBO list to VO list
   *
   * @param employees employee BO list
   * @return employee VO list
   */
  public static List<EmployeeVo> convertToVos(List<Employee> employees) {
    List<EmployeeVo> vos = new ArrayList<>();
    if (null != employees && employees.size() > 0) {
      for (Employee employee : employees) {
        vos.add(convertToVo(employee));
      }
    }
    return vos;
  }
}
