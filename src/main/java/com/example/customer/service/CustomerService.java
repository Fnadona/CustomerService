package com.example.customer.service;

import com.example.customer.exceptions.UserNotFoundException;
import com.example.customer.model.request.CustomerRequest;
import com.example.customer.model.response.CustomerResponse;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.sql.SQLException;

public interface CustomerService {

    CustomerResponse registerCustomer(CustomerRequest customer);

    CustomerResponse getCustomerById(Long id) throws UserNotFoundException;
}
