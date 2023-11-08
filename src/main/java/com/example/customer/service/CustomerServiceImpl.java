package com.example.customer.service;

import com.example.customer.model.request.CustomerRequest;
import com.example.customer.model.entity.CustomerEntity;
import com.example.customer.model.response.CustomerResponse;
import com.example.customer.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerResponse customerResponse;

    private static final Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class.getSimpleName());

    public CustomerResponse registerCustomer(CustomerRequest customer){
        try{
            CustomerEntity customerEntity = customerRepository.save(new CustomerEntity(customer));

            return customerResponse.fromEntity(customerEntity);
        } catch (Exception e){
            throw new RuntimeException("It wasn't possible to persist the customer", e.getCause());
        }
    }
}
