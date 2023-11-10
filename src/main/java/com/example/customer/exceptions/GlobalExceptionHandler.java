package com.example.customer.exceptions;

import com.example.customer.exceptions.structure.ErrorMessage;
import com.example.customer.exceptions.structure.GeneralError;
import com.example.customer.exceptions.structure.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private ErrorResponse errorResponse;

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class.getSimpleName());

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
                                                                  HttpStatusCode status, WebRequest request) {

        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());

        return buildErrorResponse(
                HttpStatus.BAD_REQUEST,
                GeneralError.COMPLETING_INVALID_FIELD,
                errors);
    }

    @ExceptionHandler(UserNotFoundException.class)
    protected ResponseEntity<Object> handleNotFound(RuntimeException ex) {

        log.error(ex.toString());

        return buildErrorResponse(
                HttpStatus.NOT_FOUND,
                GeneralError.CUSTOMER_NOT_FOUND,
                List.of(ErrorMessage.CUSTOMER_NOT_FOUND_MESSAGE));
    }

    private ResponseEntity<Object> buildErrorResponse(HttpStatus status, GeneralError generalError, List<String> errorMessageList){

        errorResponse.setStatus(status);
        errorResponse.setError(generalError);
        errorResponse.setSpecificErrorMessages(errorMessageList);

        return new ResponseEntity<>(errorResponse, status);
    }
}
