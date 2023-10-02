package com.example.customer.model.entity;

import com.example.customer.model.AccountStatus;
import com.example.customer.model.Customer;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import org.springframework.stereotype.Component;

@Entity
@Component
@Data
@Table(name = "CUSTOMER_INFO")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "COD_ID")
    private Long id;

    @Column(name = "DES_NAME")
    private String name;

    @Column(name = "DES_ADDRESS")
    private String street;

    @Column(name = "TYP_DOCUMENT")
    private String documentType;

    @Column(name = "DES_DOCUMENT")
    private String document;

    @Column(name = "DES_EMAIL")
    private String email;

    @Column(name = "DES_PHONE")
    private String phone;

    @Column(name = "DES_STATUS")
    private String accountStatus;

    public CustomerEntity toEntity(Customer customer){

        this.setName(customer.getName());
        this.setStreet(customer.getAddress().getStreet());
        this.setDocumentType(customer.getDocumentType().toString());
        this.setDocument(customer.getDocument());
        this.setEmail(customer.getEmail());
        this.setPhone(customer.getPhone());
        this.setAccountStatus(AccountStatus.INACTIVE.toString());

        return this;
    }
}
