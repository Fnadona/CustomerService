package com.example.customer.model.request;

import com.example.customer.model.Address;
import com.example.customer.model.enums.DocumentType;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@Component
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CustomerRequest {
    private String name;
    private Address address;
    private DocumentType documentType;
    private String document;
    private String email;
    private String phone;
}
