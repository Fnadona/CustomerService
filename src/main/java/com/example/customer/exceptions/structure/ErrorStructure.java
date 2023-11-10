package com.example.customer.exceptions.structure;

import com.example.customer.exceptions.structure.ErrorStructureSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;

@JsonSerialize(using = ErrorStructureSerializer.class)
public enum ErrorStructure {
    API_USER_NOT_FOUND(123, "User not found", "http://example.com/123");
    @Getter
    private Integer errorCode;
    @Getter
    private String errorMessage;
    @Getter
    private String referenceUrl;

    ErrorStructure(Integer errorCode, String errorMessage, String referenceUrl) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.referenceUrl = referenceUrl;
    }
}
