package com.dannis.wms.dao.impl;

import com.dannis.wms.dao.ModuleDao;
import com.dannis.wms.entity.ModuleEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author deng.zhang
 * @version 1.0.0
 * @since 2015-03-17 10:50
 */
@Repository
public class ModuleDaoImpl implements ModuleDao {
    /**
     * Hibernate session factory
     */
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(ModuleEntity module) {
        Session session = sessionFactory.openSession();
        session.save(module);
        session.beginTransaction().commit();
    }

    @Override
    public void delete(String code) {
        Session session = sessionFactory.openSession();
        String hql = "delete ModuleEntity as m where m.code = ?";
        Query query = session.createQuery(hql);
        query.setString(0, code);
        query.executeUpdate();
    }

    @Override
    public ModuleEntity find(String code) {
        String hql = "from ModuleEntity as a where a.code = " + code;
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(hql);
        return (ModuleEntity) query.uniqueResult();
    }
}
