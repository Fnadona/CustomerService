package com.example.customer.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class ParseErrorException extends RuntimeException{

    private static final Logger log = LoggerFactory.getLogger(ParseErrorException.class.getSimpleName());

    public ParseErrorException(Exception e){
        log.error("An error occurred when tried to parse data. \n ERROR MESSAGE = {} \n STACK TRACE = {}", e.getMessage(), Arrays.toString(e.getStackTrace()));
    }
}
