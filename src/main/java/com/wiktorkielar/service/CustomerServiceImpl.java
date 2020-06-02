package com.wiktorkielar.service;

import com.wiktorkielar.model.Customer;
import com.wiktorkielar.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public List<Customer> getCustomers() {

        List<Customer> customers = customerRepository.getCustomers();
        logger.info("Customers retrieved from the DB");

        return customers;
    }

    @Override
    public Customer getCustomerById(int id) {

        Customer customer = customerRepository.getCustomerById(id);
        logger.info("Contract retrieved from DB: {}", customer);

        return customer;
    }

    @Override
    public void saveCustomer(Customer customer) {

        customerRepository.saveCustomer(customer);
        logger.info("Customer saved to DB: {}", customer);
    }
}
