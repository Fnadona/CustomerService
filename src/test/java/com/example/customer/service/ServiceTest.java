package com.example.customer.service;

import com.example.customer.CustomerApplication;
import com.example.customer.model.enums.AccountStatus;
import com.example.customer.model.request.CustomerRequest;
import com.example.customer.model.response.CustomerResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;

@SpringBootTest(classes = {CustomerApplication.class})
public class ServiceTest {

    @Autowired
    private CustomerService customerService;

    @Test
    @DisplayName("Testing registerCustomer method")
    public void registerCustomerTest(){
        CustomerRequestProvider.getProviders()
                .forEach((message,request) -> {
                    System.out.println(message);
                    makeAsserts(request);
                });
    }
    private void makeAsserts(CustomerRequest customerRequest){

        CustomerResponse customerResponse = customerService.registerCustomer(customerRequest);

        Assertions.assertNotNull(customerResponse.getCustomerId());

        Assertions.assertEquals(customerRequest.getName(), customerResponse.getName());
        Assertions.assertEquals(customerRequest.getDocumentType(), customerResponse.getDocumentType());
        Assertions.assertEquals(customerRequest.getDocument(), customerResponse.getDocument());
        Assertions.assertEquals(customerRequest.getEmail(), customerResponse.getEmail());
        Assertions.assertEquals(customerRequest.getPhone(), customerResponse.getPhone());
        Assertions.assertEquals(AccountStatus.INACTIVE.name(), customerResponse.getAccountStatus());

        Assertions.assertEquals(customerRequest.getAddress().getStreet(), customerResponse.getAddress().getStreet());
        Assertions.assertEquals(customerRequest.getAddress().getNumber(), customerResponse.getAddress().getNumber());
        Assertions.assertEquals(customerRequest.getAddress().getComplement(), customerResponse.getAddress().getComplement());
        Assertions.assertEquals(customerRequest.getAddress().getDistrict(), customerResponse.getAddress().getDistrict());
        Assertions.assertEquals(customerRequest.getAddress().getPostalCode(), customerResponse.getAddress().getPostalCode());
        Assertions.assertEquals(customerRequest.getAddress().getCountry(), customerResponse.getAddress().getCountry());
        Assertions.assertEquals(customerRequest.getAddress().getCity(), customerResponse.getAddress().getCity());
    }

}
