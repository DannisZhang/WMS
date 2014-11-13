package com.dannis.wms.controller;

import com.dannis.wms.dto.DepartmentDto;
import com.dannis.wms.entity.Department;
import com.dannis.wms.query.QueryParams;
import com.dannis.wms.query.result.BaseResult;
import com.dannis.wms.query.result.PaginationQueryResult;
import com.dannis.wms.query.result.SingleQueryResult;
import com.dannis.wms.service.DepartmentService;
import com.dannis.wms.vo.DepartmentVo;
import com.dannis.wms.vo.EmployeeVo;
import com.dannis.wms.web.utils.DepartmentWebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by: Dannis
 * Created on: 2014-11-09 16:51
 */
@Controller
@RequestMapping("/department")
public class DepartmentController {
  /**
   * Department service
   */
  @Autowired
  private DepartmentService departmentService;

  /**
   * Add a department
   *
   * @param dto department DTO
   * @return result
   */
  @RequestMapping(value = "/add.do")
  @ResponseBody
  public BaseResult addDepartment(DepartmentDto dto) {
    Department department = DepartmentWebUtil.convertToBo(dto);
    department.setCreatedBy(1);
    return departmentService.addDepartment(department);
  }

  /**
   * Delete a department which specified id
   *
   * @param deptId department id
   * @return result
   */
  @RequestMapping(value = "deleteDepartmentById.do")
  @ResponseBody
  public BaseResult deleteDepartmentById(int deptId) {
    return departmentService.deleteDepartment(deptId);
  }

  /**
   * Update department
   *
   * @param dto department DTO
   * @return result
   */
  @RequestMapping("/updateDepartment.do")
  @ResponseBody
  public BaseResult updateDepartment(DepartmentDto dto) {
    Department department = DepartmentWebUtil.convertToBo(dto);
    department.setModifiedBy(1);
    return departmentService.updateDepartment(department);
  }

  /**
   * Query department according to id
   *
   * @param deptId department id
   * @return result
   */
  @RequestMapping(value = "/queryById.do")
  @ResponseBody
  public SingleQueryResult<DepartmentVo> queryDepartmentById(int deptId) {
    SingleQueryResult<Department> queryResult = departmentService.queryDepartment(deptId);
    SingleQueryResult<DepartmentVo> result = new SingleQueryResult<>();
    result.setCode(queryResult.getCode());
    result.setMessage(queryResult.getMessage());
    result.setData(DepartmentWebUtil.convertToVo(queryResult.getData()));

    return result;
  }

  /**
   * Query departments according to specified query parameters
   *
   * @param queryParams query parameters
   * @return result
   */
  @RequestMapping(value = "/queryByPage.do")
  @ResponseBody
  public PaginationQueryResult<DepartmentVo> queryDepartmentByPage(QueryParams queryParams) {
    PaginationQueryResult<DepartmentVo> result = new PaginationQueryResult<>();
    PaginationQueryResult<Department> queryResult = departmentService.queryDepartments(queryParams);
    result.setCode(queryResult.getCode());
    result.setMessage(queryResult.getMessage());
    result.setTotal(queryResult.getTotal());
    result.setRows(DepartmentWebUtil.convertToVos(queryResult.getRows()));

    List<DepartmentVo> vos = new ArrayList<>();
    for (int i = 0;i < 10;i++) {
      DepartmentVo vo = new DepartmentVo();
      vo.setCode("DEPT" + i);
      vo.setName("部门" + i);
      vo.setRemark("测试数据");
      EmployeeVo manager = new EmployeeVo();
      manager.setName("经理" + i);
      vo.setManager(manager);
      DepartmentVo parent = new DepartmentVo();
      parent.setName("上级部门");
      vo.setParent(parent);
      vo.setCreatedOn(new Date());
      vo.setModifiedOn(new Date());
      vos.add(vo);
    }
    result.setCode(0);
    result.setTotal(20);
    result.setRows(vos);

    return result;
  }
}