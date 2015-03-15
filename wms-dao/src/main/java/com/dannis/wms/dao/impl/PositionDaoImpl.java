package com.dannis.wms.dao.impl;

import com.dannis.wms.dao.PositionDao;
import com.dannis.wms.model.Position;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by:  deng.zhang
 * Created on:  2014-11-10 17:55
 */
@Repository
public class PositionDaoImpl implements PositionDao {
    /**
     * Hibernate session factory
     */
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean addPosition(Position position) {
        Session session = sessionFactory.openSession();
        session.save(position);
        session.beginTransaction().commit();
        return true;
    }

    @Override
    public boolean deletePosition(int postId) {
        return false;
    }

    @Override
    public boolean updatePosition(Position position) {
        return false;
    }

    @Override
    public Position queryPosition(int postId) {
        return null;
    }

    @Override
    public List<Position> queryPositions(Map<String, Object> queryParams) {
        return null;
    }

    @Override
    public long getTotal(Map<String, Object> queryParams) {
        return 0;
    }
}
