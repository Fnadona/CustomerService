package com.example.customer.service;

import com.example.customer.exceptions.ParseErrorException;
import com.example.customer.exceptions.PersistenceErrorException;
import com.example.customer.exceptions.CustomerNotFoundException;
import com.example.customer.model.request.CustomerRequest;
import com.example.customer.model.entity.CustomerEntity;
import com.example.customer.model.response.CustomerResponse;
import com.example.customer.repository.CustomerRepository;
import jakarta.persistence.OptimisticLockException;
import org.hibernate.PersistentObjectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.text.ParseException;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerResponse customerResponse;

    @Override
    public CustomerResponse registerCustomer(CustomerRequest customer){
        try{
            CustomerEntity customerEntity = customerRepository.save(new CustomerEntity(customer));

            return customerResponse.fromEntity(customerEntity);
        } catch (IllegalArgumentException | OptimisticLockingFailureException e){
            throw new PersistenceErrorException(e);
        } catch (Exception e){
            throw new ParseErrorException(e);
        }
    }

    @Override
    public CustomerResponse getCustomerById(Long id) throws CustomerNotFoundException {

        CustomerEntity customerEntity = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));

        return customerResponse.fromEntity(customerEntity);
    }
}
