package com.dannis.wms.dao.impl;

import com.dannis.wms.dao.ActionDao;
import com.dannis.wms.entity.ActionEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author deng.zhang
 * @version 1.0.0
 * @since 2015-03-16 10:27
 */
@Repository
public class ActionDaoImpl implements ActionDao {
    /**
     * Hibernate session factory
     */
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(ActionEntity action) {
        Session session = sessionFactory.openSession();
        session.save(action);
        session.beginTransaction().commit();
    }

    @Override
    public void delete(String code) {
        Session session = sessionFactory.openSession();
        String hql = "delete ActionEntity as a where a.code = ?";
        Query query = session.createQuery(hql);
        query.setString(0, code);
        query.executeUpdate();
    }

    @Override
    public void deleteByMenuCode(String menuCode) {
        Session session = sessionFactory.openSession();
        String hql = "delete ActionEntity as a where a.menu_code = ?";
        Query query = session.createQuery(hql);
        query.setString(0, menuCode);
        query.executeUpdate();
    }

    @Override
    public ActionEntity find(String code) {
        String hql = "from ActionEntity as a where a.code = " + code;
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(hql);
        return (ActionEntity) query.uniqueResult();
    }

    @Override
    public List<ActionEntity> findByMenuCode(String menuCode) {
        String hql = "from ActionEntity as a where a.menu_code = " + menuCode;
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(hql);
        return query.list();
    }
}
