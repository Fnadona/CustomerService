package com.example.customer.controler;

import com.example.customer.model.request.CustomerRequest;
import com.example.customer.model.response.CustomerResponse;
import com.example.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerResponse> createCustomer(@RequestBody CustomerRequest customer){

        CustomerResponse response = customerService.registerCustomer(customer);

        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }
}
