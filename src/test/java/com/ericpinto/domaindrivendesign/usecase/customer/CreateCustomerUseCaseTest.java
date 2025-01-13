package com.ericpinto.domaindrivendesign.usecase.customer;

import com.ericpinto.domaindrivendesign.domain.customer.entity.Customer;
import com.ericpinto.domaindrivendesign.domain.customer.entity.valueobject.Address;
import com.ericpinto.domaindrivendesign.domain.customer.repository.CustomerRepository;
import com.ericpinto.domaindrivendesign.domain.shared.notification.NotificationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CreateCustomerUseCaseTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CreateCustomerUseCase createCustomerUseCase;

    InputCreateCustomerDTO inputCreateCustomerDTO;

    @BeforeEach
    void setUp() {
        inputCreateCustomerDTO = new InputCreateCustomerDTO(
                "John",
                "Street",
                "city",
                "Zip",
                123
        );

    }

    @Test
    void shouldCreateCustomer(){
        OutputCreateCustomerDTO createOutputDTO = createCustomerUseCase.execute(inputCreateCustomerDTO);

        assertNotNull(createOutputDTO);
        assertEquals("John", createOutputDTO.getName());
    }

    @Test
    void shouldThrowErrorWhenNameIsMissing(){
        inputCreateCustomerDTO = new InputCreateCustomerDTO(
                "",
                "Street",
                "city",
                "Zip",
                123
        );

        assertThrows(NotificationException.class, () -> {
           createCustomerUseCase.execute(inputCreateCustomerDTO);
        }, "customer: Name is required");
    }

    @Test
    void shouldThrowErrorWhenStreetIsMissing(){
        inputCreateCustomerDTO = new InputCreateCustomerDTO(
                "John",
                "",
                "city",
                "Zip",
                123
        );


        assertThrows(IllegalArgumentException.class, () -> {
            createCustomerUseCase.execute(inputCreateCustomerDTO);
        }, "Street is required");
    }



}