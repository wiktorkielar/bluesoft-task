package com.wiktorkielar.repository;

import com.wiktorkielar.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public CustomerRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public List<Customer> getCustomers() {

        Session session = sessionFactory.getCurrentSession();

        Query<Customer> query = session.createQuery("from Customer", Customer.class);
        List<Customer> customers = query.getResultList();

        return customers;
    }

    @Override
    @Transactional
    public Customer getCustomerById(int id) {

        Session session = sessionFactory.getCurrentSession();

        Customer customer = session.get(Customer.class, id);

        return customer;
    }

    @Override
    @Transactional
    public void saveCustomer(Customer customer) {

        Session session = sessionFactory.getCurrentSession();

        session.save(customer);
    }
}
