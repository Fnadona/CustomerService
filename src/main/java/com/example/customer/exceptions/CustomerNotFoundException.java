package com.example.customer.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomerNotFoundException extends RuntimeException {

    private static final Logger log = LoggerFactory.getLogger(CustomerNotFoundException.class.getSimpleName());

    public CustomerNotFoundException(Long id){
        log.error("Error to find customer = {} in database", id);
    }

}
