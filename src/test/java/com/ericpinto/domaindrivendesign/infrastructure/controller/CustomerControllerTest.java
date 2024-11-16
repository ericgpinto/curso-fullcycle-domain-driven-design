package com.ericpinto.domaindrivendesign.infrastructure.controller;

import com.ericpinto.domaindrivendesign.infrastructure.customer.repository.CustomerJpaRepository;
import com.ericpinto.domaindrivendesign.usecase.customer.*;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CustomerController.class)
@ContextConfiguration(classes = {CustomerController.class, CustomerJpaRepository.class})
class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CreateCustomerUseCase createCustomerUseCase;

    @MockBean
    private ListCustomerUseCase listCustomerUseCase;

    @Test
    void findCustomer() throws Exception {
        InputCreateCustomerDTO inputCreateCustomerDTO = new InputCreateCustomerDTO("John", "street", "city", "zip", 123);
        OutputCreateCustomerDTO outputCreateCustomerDTO = new OutputCreateCustomerDTO("1L", "John", "street", "city", "zip", 123);

        when(createCustomerUseCase.execute(inputCreateCustomerDTO)).thenReturn(outputCreateCustomerDTO);

        String customerJson = """
    {
        "name": "John",
        "streetAddress": "street",
        "city": "city",
        "zipCode": "zip",
        "number": 123
    }
    """;

        mockMvc.perform(post("/customers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(customerJson))
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.name").value("John"))
                .andExpect(jsonPath("$.streetAddress").value("street"))
                .andExpect(jsonPath("$.city").value("city"))
                .andExpect(jsonPath("$.zipCode").value("zip"))
                .andExpect(jsonPath("$.number").value(123));
    }

    @Test
    void shouldNotCreateACustomer() throws Exception {
        when(createCustomerUseCase.execute(any(InputCreateCustomerDTO.class)))
                .thenThrow(new IllegalArgumentException("Unexpected error"));

        String customerJson = """
        {
            "name": "John",
            "streetAddress": "street",
            "city": "city",
            "zipCode": "zip",
            "number": 123
        }
        """;

        mockMvc.perform(post("/customers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(customerJson))
                .andExpect(status().isInternalServerError());
    }

    @Test
    void shouldFindAllCustomers() throws Exception {
        List<OutputListCustomerDTO> outputCreateCustomerDTOList =
                Arrays.asList(
                        new OutputListCustomerDTO("John", "street", "city", "zip", 123),
                        new OutputListCustomerDTO("Jade", "street 2", "city 2", "zip 2", 456)
                );

        when(listCustomerUseCase.execute()).thenReturn(outputCreateCustomerDTOList);

        mockMvc.perform(get("/customers")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].name").value("John"))
                .andExpect(jsonPath("$[1].name").value("Jade"));
    }

}