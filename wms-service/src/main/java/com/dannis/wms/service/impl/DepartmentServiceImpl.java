package com.dannis.wms.service.impl;

import com.dannis.wms.dao.DepartmentDao;
import com.dannis.wms.dao.utils.DepartmentUtil;
import com.dannis.wms.entity.DepartmentEntity;
import com.dannis.wms.model.Department;
import com.dannis.wms.query.QueryParams;
import com.dannis.wms.query.result.BaseResult;
import com.dannis.wms.query.result.PaginationQueryResult;
import com.dannis.wms.query.result.SingleQueryResult;
import com.dannis.wms.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
            department.setCode(generateCode());
            departmentDao.addDepartment(DepartmentUtil.convertToEntity(department));
        } catch (Exception e) {
            result.setCode(BaseResult.ResultCode.FAILED);
            result.setMessage("添加部门失败");
            //TODO:log here
        }
        return result;
    }

    @Override
    public BaseResult deleteDepartmentById(int deptId) {
        BaseResult result = new BaseResult(BaseResult.ResultCode.SUCCESS, "删除部门成功");
        try {
            departmentDao.deleteDepartmentById(deptId);
        } catch (Exception e) {
            result.setCode(BaseResult.ResultCode.FAILED);
            result.setMessage("删除部门失败");
            //TODO:log here
        }
        return result;
    }

    @Override
    public BaseResult deleteDepartmentsByIds(int[] ids) {
        BaseResult result = new BaseResult(BaseResult.ResultCode.SUCCESS, "删除成功");
        try {
            departmentDao.deleteDepartmentsByIds(ids);
        } catch (Exception e) {
            result.setCode(BaseResult.ResultCode.FAILED);
            result.setMessage("删除部门失败");
            //TODO:log
        }
        return result;
    }

    @Override
    public BaseResult updateDepartment(Department department) {
        BaseResult result = new BaseResult(BaseResult.ResultCode.SUCCESS, "修改部门成功");
        try {
            departmentDao.updateDepartment(DepartmentUtil.convertToEntity(department));
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
            result.setData(DepartmentUtil.convertToModel(departmentDao.queryDepartment(deptId)));
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
            result.setRows(convertToModels(departmentDao.queryDepartments(queryParams.getParams())));
        } catch (Exception e) {
            //TODO:log here
            result.setCode(BaseResult.ResultCode.FAILED);
            result.setMessage("查询部门失败");
        }
        return result;
    }

    @Override
    public PaginationQueryResult<Department> queryDepartmentsByPage(QueryParams queryParams) {
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
            List<DepartmentEntity> departmentEntities = departmentDao.queryDepartmentByPage(queryParams.getOffset(), queryParams.getLimit(), queryParams.getParams());
            result.setRows(convertToModels(departmentEntities));
        } catch (Exception e) {
            //TODO:log here
            result.setCode(BaseResult.ResultCode.FAILED);
            result.setMessage("查询部门失败");
        }
        return result;
    }

    private List<Department> convertToModels(List<DepartmentEntity> departmentEntities) {
        List<Department> departments = new ArrayList<>();
        if (null != departmentEntities && departmentEntities.size() > 0) {
            for (DepartmentEntity departmentEntity : departmentEntities) {
                departments.add(DepartmentUtil.convertToModel(departmentEntity));
            }
        }
        return departments;
    }

    private String generateCode() {
        long maxId = departmentDao.getMaxId();
        maxId++;
        return "DEPT" + maxId / 100 + (maxId % 100) / 10 + (maxId % 100) % 10;
    }
}
