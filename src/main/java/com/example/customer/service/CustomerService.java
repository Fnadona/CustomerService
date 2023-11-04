package com.example.customer.service;

import com.example.customer.model.request.CustomerRequest;
import com.example.customer.model.entity.CustomerEntity;
import com.example.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerEntity customerEntity;

    public void saveCustomer(CustomerRequest customer){
        customerRepository.save(customerEntity.fromCustomer(customer));
    }
}
