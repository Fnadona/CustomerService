package com.example.customer.model.entity;

import com.example.customer.model.enums.AccountStatus;
import com.example.customer.model.request.CustomerRequest;
import com.example.customer.utils.FormatterUtil;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Entity
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
    private String documentType;

    @Column(name = "DES_DOCUMENT_CODE")
    private String documentCode;

    @Column(name = "DES_EMAIL")
    private String email;

    @Column(name = "DES_PHONE")
    private String phone;

    @Column(name = "DES_STATUS")
    private String accountStatus;

    public CustomerEntity (CustomerRequest customer){

        this.name = FormatterUtil.formatField(customer.getName());
        this.address = new AddressEntity(customer.getAddress());
        this.documentType = customer.getDocumentType().toUpperCase();
        this.documentCode = customer.getDocumentCode().trim().toUpperCase();
        this.email = customer.getEmail().toUpperCase();
        this.phone = useTrim(customer.getPhone());
        this.accountStatus = AccountStatus.INACTIVE.name();

    }

    private String useTrim(String field){
        if (field == null){
            return null;
        } else
            return field.trim();
    }
}
