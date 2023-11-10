package com.example.customer.service;

import com.example.customer.exceptions.structure.ErrorMessage;
import com.example.customer.exceptions.UserNotFoundException;
import com.example.customer.model.request.CustomerRequest;
import com.example.customer.model.entity.CustomerEntity;
import com.example.customer.model.response.CustomerResponse;
import com.example.customer.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerResponse customerResponse;

    private static final Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class.getSimpleName());

    @Override
    public CustomerResponse registerCustomer(CustomerRequest customer){
        try{
            CustomerEntity customerEntity = customerRepository.save(new CustomerEntity(customer));

            return customerResponse.fromEntity(customerEntity);
        } catch (Exception e){
            throw new RuntimeException(ErrorMessage.SQL_PERSISTENCE_ERROR_MESSAGE, e.getCause());
        }
    }

    @Override
    public CustomerResponse getCustomerById(Long id) throws UserNotFoundException {

        CustomerEntity customerEntity = customerRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);

        return customerResponse.fromEntity(customerEntity);
    }
}
