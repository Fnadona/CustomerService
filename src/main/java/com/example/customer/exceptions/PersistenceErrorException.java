package com.example.customer.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PersistenceErrorException extends RuntimeException{

    private static final Logger log = LoggerFactory.getLogger(PersistenceErrorException.class.getSimpleName());

    public PersistenceErrorException(Exception e){
        log.error("An error occurred when tried to persist data. ERROR = {}", e.toString());
    }
}
