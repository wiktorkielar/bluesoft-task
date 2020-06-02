package com.wiktorkielar.repository;

import com.wiktorkielar.model.Customer;

import java.util.List;

public interface CustomerRepository {
    public List<Customer> getCustomers();

    public Customer getCustomerById(int id);

    public void saveCustomer(Customer customer);
}
