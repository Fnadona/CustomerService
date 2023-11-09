package com.example.customer.controler;

import com.example.customer.model.request.CustomerRequest;
import com.example.customer.model.response.CustomerResponse;
import com.example.customer.service.CustomerService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    private static final Logger log = LoggerFactory.getLogger(CustomerController.class.getSimpleName());

    @PostMapping
    public ResponseEntity<CustomerResponse> createCustomer(@Valid @RequestBody  CustomerRequest customer) {

        log.info("Requesting for create a customer");

        try {
            CustomerResponse response = customerService.registerCustomer(customer);

            log.info("Customer created successfully");

            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("An error occurred. \nMESSAGE = {} \nCAUSE = {}", e.getMessage(), e.getCause().toString());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
