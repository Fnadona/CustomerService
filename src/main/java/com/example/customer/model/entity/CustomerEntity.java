package com.example.customer.model.entity;

import com.example.customer.model.enums.AccountStatus;
import com.example.customer.model.request.CustomerRequest;
import jakarta.persistence.*;
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "COD_ADDRESS_ID", referencedColumnName = "COD_ID")
    private AddressEntity address;

    @Column(name = "TYP_DOCUMENT_TYPE")
    private String documentType;

    @Column(name = "DES_DOCUMENT")
    private String document;

    @Column(name = "DES_EMAIL")
    private String email;

    @Column(name = "DES_PHONE")
    private String phone;

    @Column(name = "DES_STATUS")
    private String accountStatus;

    public CustomerEntity fromCustomer(CustomerRequest customer){

        this.setName(customer.getName());
        this.setAddress(new AddressEntity(customer.getAddress()));
        this.setDocumentType(customer.getDocumentType().toString());
        this.setDocument(customer.getDocument());
        this.setEmail(customer.getEmail());
        this.setPhone(customer.getPhone());
        this.setAccountStatus(AccountStatus.INACTIVE.toString());

        return this;
    }
}
