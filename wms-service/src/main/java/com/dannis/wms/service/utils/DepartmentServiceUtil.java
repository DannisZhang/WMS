package com.dannis.wms.service.utils;

import com.dannis.wms.entity.Department;
import com.dannis.wms.po.DepartmentPo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by:  deng.zhang
 * Created on:  2014-11-12 12:26
 */
public class DepartmentServiceUtil {
  public static DepartmentPo covertToPo(Department department) {
    DepartmentPo po = new DepartmentPo();
    po.setId(department.getId());
    po.setCnName(department.getCnName());
    po.setEnName(department.getEnName());
    po.setCode(department.getCode());
    po.setLocation(department.getLocation());
    po.setEstablishedDate(department.getEstablishedDate());
    po.setRemark(department.getRemark());

    if (null != department.getParent()) {
      po.setParentId(department.getParent().getId());
    }
    po.setStatus(department.getStatus());
    po.setCreatedOn(department.getCreatedOn());
    po.setCreatedBy(department.getCreatedBy());
    po.setModifiedOn(department.getModifiedOn());
    po.setModifiedBy(department.getModifiedBy());

    return po;
  }

  public static Department convertToBo(DepartmentPo po) {
    Department department = new Department();
    department.setId(po.getId());
    department.setCnName(po.getCnName());
    department.setEnName(po.getEnName());
    department.setCode(po.getCode());
    department.setLocation(po.getLocation());
    department.setEstablishedDate(po.getEstablishedDate());
    department.setRemark(po.getRemark());

    Department parent = new Department();
    parent.setId(po.getParentId());
    department.setParent(parent);

    department.setStatus(po.getStatus());
    department.setCreatedOn(po.getCreatedOn());
    department.setCreatedBy(po.getCreatedBy());
    department.setModifiedOn(po.getModifiedOn());
    department.setModifiedBy(po.getModifiedBy());

    return department;
  }

  public static List<Department> convertToBos(List<DepartmentPo> pos) {
    List<Department> departments = new ArrayList<>();
    if (null != pos && pos.size() > 0) {
      for (DepartmentPo po : pos) {
        departments.add(convertToBo(po));
      }
    }

    return departments;
  }
}
