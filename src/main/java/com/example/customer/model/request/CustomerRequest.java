package com.example.customer.model.request;

import com.example.customer.model.Address;
import com.example.customer.model.enums.DocumentType;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CustomerRequest {

    @NotBlank(message = "The name is required")
    private String name;

    @Valid
    private Address address;

    private DocumentType documentType;

    @NotBlank(message = "The document is required")
    private String document;

    @NotBlank(message = "The email is required")
    @Email(message = "The email is invalid", flags = {Pattern.Flag.CASE_INSENSITIVE})
    private String email;

    private String phone;
}
