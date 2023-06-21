package com.example.orderingSystem.services;

import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.orderingSystem.mapper.CustomerMapper;
import com.example.orderingSystem.model.entity.CustomerEntity;
import com.example.orderingSystem.model.pojo.CustomerDao;
import com.example.orderingSystem.repository.CustomerRepository;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public Optional<CustomerDao> registerCustomer(CustomerDao customer) {
        CustomerEntity customerEntity = customerMapper.mapToCustomerEntity(customer);
        customerEntity = customerRepository.save(customerEntity);
        return Optional.ofNullable(customerMapper.mapToCustomerDao(customerEntity));
    }

    @Override
    public Optional<CustomerDao> updateCustomer(CustomerDao customer, Long customerId) {
       CustomerEntity customerEntity=new CustomerEntity();
        if (customerRepository.existsById(customerId)) {
            customerEntity = customerRepository.findById(customerId).get();
            customerMapper.mapToCustomerEntity(customer);
            customerEntity.setId(customerId);
            return Optional.ofNullable(customerMapper.mapToCustomerDao(customerRepository.save(customerEntity)));
        }
        customerMapper.mapToCustomerEntity(customer);
        customerEntity = customerRepository.save(customerEntity);
        return Optional.ofNullable(customerMapper.mapToCustomerDao(customerEntity));
    }

    @Override
    public void deleteCustomer(Long customerId) {
        if (customerRepository.existsById(customerId)) {
            CustomerEntity customerEntity=customerRepository.findById(customerId).get();
            customerRepository.delete(customerEntity);
        }
    }

    @Override
    public Optional<CustomerDao> getCustomerById(Long customerId) {
        CustomerEntity cuEntity = customerRepository.findById(customerId).get();
        return Optional.ofNullable(customerMapper.mapToCustomerDao(cuEntity));
    }

}
