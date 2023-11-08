package com.example.customer.service;

import com.example.customer.model.Address;
import com.example.customer.model.enums.AccountStatus;
import com.example.customer.model.enums.DocumentType;
import com.example.customer.model.request.CustomerRequest;
import com.example.customer.model.response.CustomerResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ServiceTest {

    @Autowired
    private CustomerService customerService;

    @Test
    @DisplayName("Testing registerCustomer method")
    void registerCustomerTest(){
        CustomerRequest request = createCustomerRequest();
        CustomerResponse customerResponse = customerService.registerCustomer(request);

        Assertions.assertNotNull(customerResponse.getCustomerId());

        Assertions.assertEquals(request.getName(), customerResponse.getName());
        Assertions.assertEquals(request.getDocumentType(), customerResponse.getDocumentType());
        Assertions.assertEquals(request.getDocument(), customerResponse.getDocument());
        Assertions.assertEquals(request.getEmail(), customerResponse.getEmail());
        Assertions.assertEquals(request.getPhone(), customerResponse.getPhone());
        Assertions.assertEquals(AccountStatus.INACTIVE, customerResponse.getAccountStatus());

        Assertions.assertEquals(request.getAddress().getStreet(), customerResponse.getAddress().getStreet());
        Assertions.assertEquals(request.getAddress().getNumber(), customerResponse.getAddress().getNumber());
        Assertions.assertEquals(request.getAddress().getComplement(), customerResponse.getAddress().getComplement());
        Assertions.assertEquals(request.getAddress().getDistrict(), customerResponse.getAddress().getDistrict());
        Assertions.assertEquals(request.getAddress().getPostalCode(), customerResponse.getAddress().getPostalCode());
        Assertions.assertEquals(request.getAddress().getCountry(), customerResponse.getAddress().getCountry());
        Assertions.assertEquals(request.getAddress().getCity(), customerResponse.getAddress().getCity());
    }

    private CustomerRequest createCustomerRequest(){

        CustomerRequest customerRequest = new CustomerRequest();

        customerRequest.setName("Nome teste");
        customerRequest.setAddress(createAddress());
        customerRequest.setDocumentType(DocumentType.DRIVE_LICENSE);
        customerRequest.setDocument("documento teste");
        customerRequest.setEmail("emailteste@teste.com");
        customerRequest.setPhone("321654987");

        return customerRequest;
    }

    private Address createAddress(){

        Address address = new Address();

        address.setStreet("Rua teste");
        address.setNumber("123456");
        address.setComplement("Complemento teste");
        address.setDistrict("Bairro teste");
        address.setPostalCode("12345678");
        address.setCountry("Pais teste");
        address.setCity("Cidade teste");

        return address;
    }
}
