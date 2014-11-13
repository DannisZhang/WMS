package com.dannis.wms.dao.impl;

import com.dannis.wms.dao.DepartmentDao;
import com.dannis.wms.po.DepartmentPo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by: Dannis
 * Created on: 2014-11-09 12:41
 */
@Repository
public class DepartmentDaoImpl implements DepartmentDao {
  /**
   * Hibernate session factory
   */
  @Autowired
  private SessionFactory sessionFactory;

  @Override
  public boolean addDepartment(DepartmentPo department) {
    Session session = sessionFactory.openSession();
    session.save(department);
    session.beginTransaction().commit();
    return true;
  }

  @Override
  public boolean deleteDepartment(int deptId) {
    return false;
  }

  @Override
  public boolean updateDepartment(DepartmentPo department) {
    return false;
  }

  @Override
  public DepartmentPo queryDepartment(int deptId) {
    return null;
  }

  @Override
  public List<DepartmentPo> queryDepartments(Map<String, Object> queryParams) {
    return null;
  }

  @Override
  public long getTotal(Map<String, Object> queryParams) {
    return 0;
  }
}
