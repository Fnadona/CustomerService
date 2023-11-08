package com.example.customer.service;

import com.example.customer.model.request.CustomerRequest;
import com.example.customer.model.response.CustomerResponse;

import java.sql.SQLException;

public interface CustomerService {

    CustomerResponse registerCustomer(CustomerRequest customer);
}
