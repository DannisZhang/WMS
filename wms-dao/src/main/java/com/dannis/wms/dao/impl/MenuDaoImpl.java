package com.dannis.wms.dao.impl;

import com.dannis.wms.common.utils.StringUtil;
import com.dannis.wms.dao.MenuDao;
import com.dannis.wms.entity.MenuEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author deng.zhang
 * @version 1.0.0
 * @since 2015-03-17 10:43
 */
@Repository
public class MenuDaoImpl implements MenuDao {
    /**
     * Hibernate session factory
     */
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(MenuEntity menu) {
        Session session = sessionFactory.openSession();
        session.save(menu);
        session.beginTransaction().commit();
    }

    @Override
    public void delete(String code) {
        Session session = sessionFactory.openSession();
        String hql = "delete MenuEntity as m where m.code = ?";
        Query query = session.createQuery(hql);
        query.setString(0, code);
        query.executeUpdate();
    }

    @Override
    public void deleteByCodes(List<String> codes) {
        Session session = sessionFactory.openSession();
        String hql = "delete MenuEntity as m where m.code in (?)";
        Query query = session.createQuery(hql);
        query.setString(0, StringUtil.listToString(codes,","));
        query.executeUpdate();
    }

    @Override
    public void deleteByModuleCode(String moduleCode) {
        Session session = sessionFactory.openSession();
        String hql = "delete MenuEntity as m where m.module_code = ?";
        Query query = session.createQuery(hql);
        query.setString(0, moduleCode);
        query.executeUpdate();
    }

    @Override
    public MenuEntity find(String code) {
        String hql = "from MenuEntity as m where m.code = " + code;
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(hql);
        return (MenuEntity) query.uniqueResult();
    }

    @Override
    public List<MenuEntity> findByModuleCode(String moduleCode) {
        String hql = "from MenuEntity as m where m.module_code = " + moduleCode;
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(hql);
        return query.list();
    }

    @Override
    public List<MenuEntity> findByPage(int start, int maxSize, Map<String, String> queryParams) {
        String hql = "from MenuEntity";
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
        String hql = "select count(menu.id) from MenuEntity as menu";
        if (null != queryParams) {
            //TODO:add condition
        }
        Query query = session.createQuery(hql);
        return (Long)query.list().get(0);
    }

    @Override
    public long findMaxId() {
        String hql = "select max(menu.id) from MenuEntity as menu";
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(hql);
        return (Long)query.list().get(0);
    }
}
