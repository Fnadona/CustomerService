package com.example.customer.controler;

import com.example.customer.model.request.CustomerRequest;
import com.example.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping
    public CustomerRequest createCustomer(@RequestBody CustomerRequest customer){
        customerService.saveCustomer(customer);
        return customer;
    }
}
