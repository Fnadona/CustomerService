package com.example.customer.model.response;

import com.example.customer.model.Address;
import com.example.customer.model.entity.CustomerEntity;
import com.example.customer.model.enums.AccountStatus;
import com.example.customer.model.enums.DocumentType;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CustomerResponse {

    private Long customerId;
    private String name;
    private Address address;
    private DocumentType documentType;
    private String document;
    private String email;
    private String phone;
    private AccountStatus accountStatus;

    public CustomerResponse fromEntity(CustomerEntity customerEntity){

        this.customerId = customerEntity.getId();
        this.name = customerEntity.getName();
        this.address = new Address(customerEntity.getAddress());
        this.documentType = customerEntity.getDocumentType();
        this.document = customerEntity.getDocument();
        this.email = customerEntity.getEmail();
        this.phone = customerEntity.getPhone();
        this.accountStatus = customerEntity.getAccountStatus();

        return this;

    }

}
