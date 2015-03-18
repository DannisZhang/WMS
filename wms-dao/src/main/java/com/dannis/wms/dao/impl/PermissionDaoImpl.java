package com.dannis.wms.dao.impl;

import com.dannis.wms.dao.PermissionDao;
import com.dannis.wms.entity.PermissionEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author deng.zhang
 * @version 1.0.0
 * @since 2015-03-17 10:54
 */
@Repository
public class PermissionDaoImpl implements PermissionDao {
    /**
     * Hibernate session factory
     */
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public void save(PermissionEntity permission) {
        Session session = sessionFactory.openSession();
        session.save(permission);
        session.beginTransaction().commit();
    }

    @Override
    public void delete(String code) {
        Session session = sessionFactory.openSession();
        String hql = "delete PermissionEntity as m where m.code = ?";
        Query query = session.createQuery(hql);
        query.setString(0, code);
        query.executeUpdate();
    }

    @Override
    public PermissionEntity find(String code) {
        String hql = "from PermissionEntity as a where a.code = " + code;
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(hql);
        return (PermissionEntity) query.uniqueResult();
    }

    @Override
    public List<PermissionEntity> findByRoleCode(String roleCode) {
        String hql = "from PermissionEntity as a where a.role_code = " + roleCode;
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(hql);
        return query.list();
    }
}
