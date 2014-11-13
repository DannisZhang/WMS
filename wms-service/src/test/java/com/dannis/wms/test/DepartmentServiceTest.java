package com.dannis.wms.test;

import com.dannis.wms.entity.Department;
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
    Department department = new Department();
    department.setName("信息技术部");
    department.setCode("DEPT001");
    department.setRemark("信息技术部");
    departmentService.addDepartment(department);
  }
}
