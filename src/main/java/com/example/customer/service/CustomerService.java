package com.example.customer.service;

import com.example.customer.exceptions.CustomerNotFoundException;
import com.example.customer.model.request.CustomerRequest;
import com.example.customer.model.response.CustomerResponse;

public interface CustomerService {

    CustomerResponse registerCustomer(CustomerRequest customer);

    CustomerResponse getCustomerById(Long id) throws CustomerNotFoundException;
}
