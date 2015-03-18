package com.dannis.wms.dao.impl;

import com.dannis.wms.dao.UserDao;
import com.dannis.wms.entity.UserEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author deng.zhang
 * @version 1.0.0
 * @since 2015-03-17 11:02
 */
@Repository
public class UserDaoImpl implements UserDao {
    /**
     * Hibernate session factory
     */
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public void save(UserEntity user) {
        Session session = sessionFactory.openSession();
        session.save(user);
        session.beginTransaction().commit();
    }

    @Override
    public void delete(String code) {
        Session session = sessionFactory.openSession();
        String hql = "delete UserEntity as u where u.code = ?";
        Query query = session.createQuery(hql);
        query.setString(0, code);
        query.executeUpdate();
    }

    @Override
    public UserEntity find(String code) {
        String hql = "from UserEntity as u where u.code = " + code;
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(hql);
        return (UserEntity) query.uniqueResult();
    }
}
