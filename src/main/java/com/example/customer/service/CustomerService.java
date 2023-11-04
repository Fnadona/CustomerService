package com.example.customer.service;

import com.example.customer.model.request.CustomerRequest;
import com.example.customer.model.entity.CustomerEntity;
import com.example.customer.model.response.CustomerResponse;
import com.example.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerResponse customerResponse;

    public CustomerResponse registerCustomer(CustomerRequest customer){

        CustomerEntity customerEntity = customerRepository.save(new CustomerEntity(customer));

        return customerResponse.fromEntity(customerEntity);

    }
}
