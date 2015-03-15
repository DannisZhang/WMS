package com.dannis.wms.controller;

import com.dannis.wms.model.Department;
import com.dannis.wms.query.QueryParams;
import com.dannis.wms.query.result.BaseResult;
import com.dannis.wms.query.result.PaginationQueryResult;
import com.dannis.wms.query.result.SingleQueryResult;
import com.dannis.wms.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
     * @param department 部门
     * @return result
     */
    @RequestMapping(value = "/add.json", method = RequestMethod.POST)
    @ResponseBody
    public BaseResult addDepartment(Department department) {
        return departmentService.addDepartment(department);
    }

    /**
     * Delete a department which specified id
     *
     * @param deptId department id
     * @return result
     */
    @RequestMapping(value = "/deleteDepartmentById.json", method = RequestMethod.POST)
    @ResponseBody
    public BaseResult deleteDepartmentById(int deptId) {
        return departmentService.deleteDepartmentById(deptId);
    }

    /**
     * Delete departments those id equal the specified id list
     *
     * @param ids id list
     * @return result
     */
    @RequestMapping(value = "/deleteDepartmentsByIds.json", method = RequestMethod.POST)
    @ResponseBody
    public BaseResult deleteDepartmentsByIds(int[] ids) {
        return departmentService.deleteDepartmentsByIds(ids);
    }

    /**
     * 更新部门
     *
     * @param department 部门
     * @return result
     */
    @RequestMapping("/update.json")
    @ResponseBody
    public BaseResult updateDepartment(Department department) {
        return departmentService.updateDepartment(department);
    }

    /**
     * 根据ID查询部门
     *
     * @param deptId department id
     * @return result
     */
    @RequestMapping(value = "/queryById.json", method = RequestMethod.GET)
    @ResponseBody
    public SingleQueryResult<Department> queryDepartmentById(int deptId) {
        SingleQueryResult<Department> queryResult = departmentService.queryDepartment(deptId);
        SingleQueryResult<Department> result = new SingleQueryResult<>();
        result.setCode(queryResult.getCode());
        result.setMessage(queryResult.getMessage());
        result.setData(queryResult.getData());

        return result;
    }

    /**
     * Query departments according to specified query parameters
     *
     * @param queryParams query parameters
     * @return result
     */
    @RequestMapping(value = "/queryByPage.json")
    @ResponseBody
    public PaginationQueryResult<Department> queryDepartmentByPage(QueryParams queryParams) {
        PaginationQueryResult<Department> result = new PaginationQueryResult<>();
        PaginationQueryResult<Department> queryResult = departmentService.queryDepartmentsByPage(queryParams);
        result.setCode(queryResult.getCode());
        result.setMessage(queryResult.getMessage());
        result.setTotal(queryResult.getTotal());
        result.setRows(queryResult.getRows());

        return result;
    }
}
