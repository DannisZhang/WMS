package com.dannis.wms.dao.impl;

import com.dannis.wms.dao.DepartmentDao;
import com.dannis.wms.po.DepartmentPo;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Arrays;
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
  public boolean deleteDepartmentById(int deptId) {
    Session session = sessionFactory.openSession();
    String hql = "delete DepartmentPo as d where d.id=?";
    Query query = session.createQuery(hql);
    query.setInteger(0,deptId);
    query.executeUpdate();
    return true;
  }

  @Override
  public boolean deleteDepartmentsByIds(int[] ids) {
    Session session = sessionFactory.openSession();
    String hql = "delete DepartmentPo as d where d.id in (";
    for (int id : ids) {
      hql += id + ",";
    }
    hql = hql.substring(0,hql.lastIndexOf(",")) + ")";
    Query query = session.createQuery(hql);
    query.executeUpdate();
    return true;
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
  public List<DepartmentPo> queryDepartments(Map<String, String> queryParams) {
//    String sql = "SELECT id,name,code,remark,created_on,created_by,modified_on,modified_by "
//            + "FROM t_dept "
//            + "LIMIT " + queryParams.get("offset") + "," + queryParams.get("limit");
    String hql = "from DepartmentPo";
    Session session = sessionFactory.openSession();
    Query query = session.createQuery(hql);
    return query.list();
  }

  @Override
  public List<DepartmentPo> queryDepartmentByPage(int start, int maxSize, Map<String, String> queryParams) {

    String hql = "from DepartmentPo";
    if (null != queryParams) {
      //TODO:add condition
    }
    Session session = sessionFactory.openSession();
    Query query = session.createQuery(hql);
    query.setFirstResult(start);
    query.setMaxResults(maxSize);
    return query.list();
  }

  @Override
  public long getTotal(Map<String, String> queryParams) {
    Session session = sessionFactory.openSession();
    String sql = "SELECT COUNT(id) FROM t_dept WHERE 1 = 1";
    if (null != queryParams) {
      //TODO:add condition
    }
    Query query = session.createSQLQuery(sql);
    BigInteger bigInteger = (BigInteger)query.list().get(0);
    return bigInteger.longValue();
  }
}
