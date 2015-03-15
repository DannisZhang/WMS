package com.dannis.wms.dao.utils;

import com.dannis.wms.entity.DepartmentEntity;
import com.dannis.wms.model.Department;

/**
 * 部门工具类
 * 
 * Created by: Dannis
 * Created on: 2015-03-15 17:18
 */
public class DepartmentUtil {
    /**
     * 将数据库实体对象转换成业务模型对象
     * 
     * @param departmentEntity 数据库实体对象
     * @return  业务模型对象
     */
    public static Department convertToModel(DepartmentEntity departmentEntity) {
        Department department = null;
        if (departmentEntity != null) {
            department = new Department();
            department.setCode(departmentEntity.getCode());
            department.setName(departmentEntity.getName());
            department.setEstablishedDate(departmentEntity.getEstablishedDate());
            department.setLocation(departmentEntity.getLocation());
            department.setRemark(departmentEntity.getRemark());
        }
        return department;
    }

    /**
     * 将业务模型对象转换成数据库实体对象
     * @param department 业务模型对象
     * @return 数据库实体对象
     */
    public static DepartmentEntity convertToEntity(Department department) {
        DepartmentEntity departmentEntity = null;
        if (department != null) {
            departmentEntity = new DepartmentEntity();
            departmentEntity.setName(department.getName());
            departmentEntity.setEstablishedDate(department.getEstablishedDate());
            departmentEntity.setRemark(department.getRemark());
        }
        return departmentEntity;
    }
}
