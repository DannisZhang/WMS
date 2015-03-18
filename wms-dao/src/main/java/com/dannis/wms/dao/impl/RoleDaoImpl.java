package com.dannis.wms.dao.impl;

import com.dannis.wms.dao.RoleDao;
import com.dannis.wms.entity.RoleEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author deng.zhang
 * @version 1.0.0
 * @since 2015-03-17 10:58
 */
@Repository
public class RoleDaoImpl implements RoleDao {
    /**
     * Hibernate session factory
     */
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public void save(RoleEntity role) {
        Session session = sessionFactory.openSession();
        session.save(role);
        session.beginTransaction().commit();
    }

    @Override
    public void delete(String code) {
        Session session = sessionFactory.openSession();
        String hql = "delete RoleEntity as r where r.code = ?";
        Query query = session.createQuery(hql);
        query.setString(0, code);
        query.executeUpdate();
    }

    @Override
    public RoleEntity find(String code) {
        String hql = "from RoleEntity as r where r.code = " + code;
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(hql);
        return (RoleEntity) query.uniqueResult();
    }

    @Override
    public List<RoleEntity> findByUserCode(String userCode) {
        String hql = "from RoleEntity as a where a.user_code = " + userCode;
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(hql);
        return query.list();
    }
}
