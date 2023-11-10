package com.example.customer.service;

import com.example.customer.exceptions.ParseErrorException;
import com.example.customer.exceptions.PersistenceErrorException;
import com.example.customer.exceptions.CustomerNotFoundException;
import com.example.customer.model.request.CustomerRequest;
import com.example.customer.model.entity.CustomerEntity;
import com.example.customer.model.response.CustomerResponse;
import com.example.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{
    private final CustomerRepository customerRepository;

    private final CustomerResponse customerResponse;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerResponse customerResponse){
        this.customerRepository = customerRepository;
        this.customerResponse = customerResponse;
    }

    @Override
    public CustomerResponse registerCustomer(CustomerRequest customerRequest){

        try{
            return saveCustomer(customerRequest);
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

    private CustomerResponse saveCustomer(CustomerRequest customerRequest) {
        CustomerEntity customerEntity = customerRepository.save(new CustomerEntity(customerRequest));

        return customerResponse.fromEntity(customerEntity);
    }

}
