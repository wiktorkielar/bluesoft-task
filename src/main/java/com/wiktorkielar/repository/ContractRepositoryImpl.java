package com.wiktorkielar.repository;

import com.wiktorkielar.model.Contract;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ContractRepositoryImpl implements ContractRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public ContractRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public List<Contract> getContracts() {

        Session session = sessionFactory.getCurrentSession();

        Query<Contract> query = session.createQuery("from Contract", Contract.class);
        List<Contract> contracts = query.list();

        return contracts;
    }

    @Override
    @Transactional
    public List<Contract> getActiveContracts() {

        Session session = sessionFactory.getCurrentSession();

        Query<Contract> query = session.createQuery("from Contract where active=true", Contract.class);
        List<Contract> contracts = query.list();

        return contracts;
    }

    @Override
    @Transactional
    public Contract getContractById(int id) {

        Session session = sessionFactory.getCurrentSession();

        Contract contract = session.get(Contract.class, id);

        return contract;
    }


    @Override
    @Transactional
    public void saveContract(Contract contract) {

        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(contract);
    }

    @Override
    @Transactional
    public void deleteContractById(int contractId) {

        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("delete from Contract where id=:contractId");
        query.setParameter("contractId", contractId);

        query.executeUpdate();
    }
}
