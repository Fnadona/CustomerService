package com.example.customer.service;

import com.example.customer.model.Address;
import com.example.customer.model.enums.DocumentType;
import com.example.customer.model.request.CustomerRequest;

import java.util.HashMap;
import java.util.Map;

public abstract class CustomerRequestProvider {

    static private final Map<String, CustomerRequest> providers = new HashMap<>();
    static public Map<String, CustomerRequest> getProviders(){
        addToProvider();
        return providers;
    }

    static private void addToProvider(){

        providers.put("Request with all fields", customerRequestWithAllFields);
        providers.put("Request without phone", customerRequestWithoutPhone);
    }
    static final private Address addressWithAllFields = Address.builder()
                .street("Rua teste")
                .number("123456")
                .complement("Complemento teste")
                .district("Bairro teste")
                .postalCode("12345678")
                .city("Cidade teste")
                .country("País teste")
                .build();

    static final private CustomerRequest customerRequestWithAllFields =
            CustomerRequest.builder()
                .name("Nome teste")
                .address(addressWithAllFields)
                .documentType(DocumentType.DRIVE_LICENSE)
                .document("Documento teste")
                .email("emailteste@teste.com")
                .phone("321654987")
                .build();

    static final private CustomerRequest customerRequestWithoutPhone =
            CustomerRequest.builder()
                .name("Nome teste")
                .address(addressWithAllFields)
                .documentType(DocumentType.DRIVE_LICENSE)
                .document("Documento teste")
                .email("emailteste@teste.com")
                .build();
}
