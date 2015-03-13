package com.dannis.wms.web.utils;

import com.dannis.wms.common.utils.DateUtil;
import com.dannis.wms.dto.DepartmentDto;
import com.dannis.wms.entity.Department;
import com.dannis.wms.entity.Employee;
import com.dannis.wms.vo.DepartmentVo;
import com.dannis.wms.vo.EmployeeVo;

import java.util.ArrayList;
import java.util.List;

/**
 * Department utility,used to convert Department DTO to BO and BO to VO
 * Created by:  deng.zhang
 * Created on:  2014-11-10 22:43
 */
public class DepartmentWebUtil {
  /**
   * Convert Department DTO to BO
   *
   * @param dto Department DTO
   * @return Department BO
   */
  public static Department convertToBo(DepartmentDto dto) {
    Department department = new Department();
    department.setId(Integer.parseInt(dto.getDepartmentId()));
    department.setCnName(dto.getCnName());
    department.setEnName(dto.getEnName());
    department.setCode(dto.getCode());
    department.setLocation(dto.getLocation());
    department.setEstablishedDate(DateUtil.stringToDate(dto.getEstablishedDate()));

    Department parent = new Department();
    parent.setId(dto.getParentId());
    department.setParent(parent);
    department.setRemark(dto.getRemark());

    Employee manager = new Employee();
    manager.setId(dto.getManagerId());
    department.setManager(manager);

    return department;
  }

  /**
   * Convert Department BO to VO
   *
   * @param bo Department BO
   * @return Department VO
   */
  public static DepartmentVo convertToVo(Department bo) {
    if (null == bo) {
      return null;
    }

    DepartmentVo departmentVo = new DepartmentVo();
    departmentVo.setId(bo.getId());
    departmentVo.setCnName(bo.getCnName());
    departmentVo.setEnName(bo.getEnName());
    departmentVo.setCode(bo.getCode());
    departmentVo.setLocation(bo.getLocation());
    departmentVo.setEstablishedDate(DateUtil.dateToString(bo.getEstablishedDate()));
    departmentVo.setRemark(bo.getRemark());


    if (null != bo.getParent()) {
      DepartmentVo parent = new DepartmentVo();
      parent.setId(bo.getParent().getId());
      parent.setCnName(bo.getParent().getCnName());
      parent.setEnName(bo.getParent().getEnName());
      parent.setCode(bo.getParent().getCode());
      parent.setLocation(bo.getParent().getLocation());
      parent.setEstablishedDate(DateUtil.dateToString(bo.getParent().getEstablishedDate()));
      departmentVo.setParent(parent);
    }

    if (null != bo.getManager()) {
      EmployeeVo manager = new EmployeeVo();
      manager.setId(bo.getManager().getId());
      manager.setName(bo.getManager().getName());
      manager.setCode(bo.getManager().getCode());
      departmentVo.setManager(manager);
    }

    departmentVo.setCreatedOn(DateUtil.dateTimeToString(bo.getCreatedOn()));
    departmentVo.setCreatedBy(bo.getCreatedBy());
    departmentVo.setModifiedOn(DateUtil.dateTimeToString(bo.getModifiedOn()));
    departmentVo.setModifiedBy(bo.getModifiedBy());

    return departmentVo;
  }

  /**
   * Convert department BO list to VO list
   *
   * @param departments department BO list
   * @return department VO list
   */
  public static List<DepartmentVo> convertToVos(List<Department> departments) {
    List<DepartmentVo> vos = new ArrayList<>();
    if (null != departments && departments.size() > 0) {
      for (Department department : departments) {
        vos.add(convertToVo(department));
      }
    }
    return vos;
  }
}
