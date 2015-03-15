package com.dannis.wms.dao.impl;

import com.dannis.wms.dao.EmployeeDao;
import com.dannis.wms.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by:  deng.zhang
 * Created on:  2014-11-10 17:56
 */
@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    /**
     * Hibernate session factory
     */
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean addEmployee(Employee employee) {
        Session session = sessionFactory.openSession();
        session.save(employee);
        session.beginTransaction().commit();
        return true;
    }

    @Override
    public boolean deleteEmployee(int empId) {
        return false;
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        return false;
    }

    @Override
    public Employee queryEmployee(int empId) {
        return null;
    }

    @Override
    public List<Employee> queryEmployees(Map<String, Object> queryParams) {
        return null;
    }

    @Override
    public long getTotal(Map<String, Object> queryParams) {
        return 0;
    }
}
