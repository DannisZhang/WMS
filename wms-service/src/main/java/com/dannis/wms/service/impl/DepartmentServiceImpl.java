package com.dannis.wms.service.impl;

import com.dannis.wms.dao.DepartmentDao;
import com.dannis.wms.entity.Department;
import com.dannis.wms.query.QueryParams;
import com.dannis.wms.query.result.BaseResult;
import com.dannis.wms.query.result.PaginationQueryResult;
import com.dannis.wms.query.result.SingleQueryResult;
import com.dannis.wms.service.DepartmentService;
import com.dannis.wms.service.utils.DepartmentServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Department service implementation
 * Created by: Dannis
 * Created on: 2014-11-09 16:54
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
  /**
   * Department DAO
   */
  @Autowired
  private DepartmentDao departmentDao;

  @Override
  public BaseResult addDepartment(Department department) {
    BaseResult result = new BaseResult(BaseResult.ResultCode.SUCCESS, "添加部门成功");
    try {
      departmentDao.addDepartment(DepartmentServiceUtil.covertToPo(department));
    } catch (Exception e) {
      result.setCode(BaseResult.ResultCode.FAILED);
      result.setMessage("添加部门失败");
      //TODO:log here
    }
    return result;
  }

  @Override
  public BaseResult deleteDepartment(int deptId) {
    BaseResult result = new BaseResult(BaseResult.ResultCode.SUCCESS, "删除部门成功");
    try {
      departmentDao.deleteDepartment(deptId);
    } catch (Exception e) {
      result.setCode(BaseResult.ResultCode.FAILED);
      result.setMessage("删除部门失败");
      //TODO:log here
    }
    return result;
  }

  @Override
  public BaseResult updateDepartment(Department department) {
    BaseResult result = new BaseResult(BaseResult.ResultCode.SUCCESS, "修改部门成功");
    try {
      departmentDao.updateDepartment(DepartmentServiceUtil.covertToPo(department));
    } catch (Exception e) {
      result.setCode(BaseResult.ResultCode.FAILED);
      result.setMessage("修改部门失败");
      //TODO:log here
    }
    return result;
  }

  @Override
  public SingleQueryResult<Department> queryDepartment(int deptId) {
    SingleQueryResult<Department> result = new SingleQueryResult<>();
    try {
      result.setData(DepartmentServiceUtil.convertToBo(departmentDao.queryDepartment(deptId)));
      result.setCode(BaseResult.ResultCode.SUCCESS);
    } catch (Exception e) {
      result.setCode(BaseResult.ResultCode.FAILED);
      result.setMessage("查询部门失败");
      //TODO:log here
    }
    return result;
  }

  @Override
  public PaginationQueryResult<Department> queryDepartments(QueryParams queryParams) {
    PaginationQueryResult<Department> result = new PaginationQueryResult<>();
    if (null == queryParams) {
      //TODO:log here
      result.setCode(BaseResult.ResultCode.FAILED);
      result.setMessage("查询部门失败，未指定查询参数");
      return result;
    }

    try {
      result.setTotal(departmentDao.getTotal(queryParams.getParams()));
      result.setCode(BaseResult.ResultCode.SUCCESS);
      result.setRows(DepartmentServiceUtil.convertToBos(departmentDao.queryDepartments(queryParams.getParams())));
    } catch (Exception e) {
      //TODO:log here
      result.setCode(BaseResult.ResultCode.FAILED);
      result.setMessage("查询部门失败");
    }
    return result;
  }
}
