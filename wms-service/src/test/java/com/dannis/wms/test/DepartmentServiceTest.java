package com.dannis.wms.test;

import com.dannis.wms.model.Department;
import com.dannis.wms.service.DepartmentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by:  deng.zhang
 * Created on:  2014-11-11 20:25
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/config/spring/applicationContext-service.xml"})
public class DepartmentServiceTest extends AbstractJUnit4SpringContextTests {
    @Resource
    private DepartmentService departmentService;

    @Test
    public void testAdd() {
        for (int i = 0; i < 20; i++) {
            Department department = new Department();
            department.setName("测试部门" + i);
            department.setCode("DEPT00000" + i);
            department.setRemark("测试部门");
            departmentService.addDepartment(department);
        }
    }
}
