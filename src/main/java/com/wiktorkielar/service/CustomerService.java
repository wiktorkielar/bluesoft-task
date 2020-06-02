package com.wiktorkielar.service;

import com.wiktorkielar.model.Customer;
import com.wiktorkielar.model.System;

import java.util.List;

public interface CustomerService {
    List<Customer> getCustomers();

    Customer getCustomerById(int id);

    void saveCustomer(Customer customer);
}
