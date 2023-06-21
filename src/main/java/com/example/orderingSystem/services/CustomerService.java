package com.example.orderingSystem.services;

import java.util.Optional;

import com.example.orderingSystem.Exception.CustomerException;
import com.example.orderingSystem.model.pojo.CustomerDao;

public interface CustomerService {
    public Optional<CustomerDao> registerCustomer(CustomerDao customer);

    public Optional<CustomerDao> updateCustomer(CustomerDao customer, Long customerId);

    public void deleteCustomer(Long customerId);

    public Optional<CustomerDao> getCustomerById(Long customerId);
}
