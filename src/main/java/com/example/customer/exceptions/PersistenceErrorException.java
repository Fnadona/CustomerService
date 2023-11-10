package com.example.customer.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class PersistenceErrorException extends RuntimeException{

    private static final Logger log = LoggerFactory.getLogger(PersistenceErrorException.class.getSimpleName());

    public PersistenceErrorException(Exception e){
        log.error("An error occurred when tried to persist data. \n ERROR MESSAGE = {} \n STACK TRACE = {}", e.getMessage(), Arrays.toString(e.getStackTrace()));
    }
}
