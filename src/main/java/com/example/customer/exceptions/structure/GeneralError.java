package com.example.customer.exceptions.structure;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;

@Getter
@JsonSerialize(using = GeneralErrorSerializer.class)
public enum GeneralError {
    CUSTOMER_NOT_FOUND(1, ErrorMessage.CUSTOMER_NOT_FOUND_MESSAGE),
    COMPLETING_INVALID_FIELD(2, ErrorMessage.COMPLETING_INVALID_FIELD_MESSAGE),
    PERSISTENCE_ERROR(3, ErrorMessage.PERSISTENCE_ERROR_MESSAGE),
    PARSE_ERROR(4, ErrorMessage.PARSE_ERROR_MESSAGE);

    private Integer errorCode;
    private String errorMessage;

    GeneralError(Integer errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
