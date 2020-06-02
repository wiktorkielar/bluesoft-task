package com.wiktorkielar.repository;

import com.wiktorkielar.model.System;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class SystemRepositoryImpl implements SystemRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public SystemRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override

    public List<System> getSystems() {

        Session session = sessionFactory.getCurrentSession();

        Query<System> query = session.createQuery("from System", System.class);
        List<System> systems = query.getResultList();

        return systems;
    }

    @Override
    @Transactional
    public System getSystemById(int id) {

        Session session = sessionFactory.getCurrentSession();
        System system = session.get(System.class, id);

        return system;
    }

    @Override
    @Transactional
    public void saveSystem(System system){

        Session session = sessionFactory.getCurrentSession();

        session.save(system);
    }
}
