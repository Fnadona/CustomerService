package com.example.customer.model.entity;

import com.example.customer.model.enums.AccountStatus;
import com.example.customer.model.enums.DocumentType;
import com.example.customer.model.request.CustomerRequest;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Entity
@Component
@Data
@Table(name = "CUSTOMER_INFO")
@NoArgsConstructor
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
    private DocumentType documentType;

    @Column(name = "DES_DOCUMENT")
    private String document;

    @Column(name = "DES_EMAIL")
    private String email;

    @Column(name = "DES_PHONE")
    private String phone;

    @Column(name = "DES_STATUS")
    private AccountStatus accountStatus;

    public CustomerEntity (CustomerRequest customer){

        this.name = customer.getName();
        this.address = new AddressEntity(customer.getAddress());
        this.documentType = customer.getDocumentType();
        this.document = customer.getDocument();
        this.email = customer.getEmail();
        this.phone = customer.getPhone();
        this.accountStatus = AccountStatus.INACTIVE;

    }
}
