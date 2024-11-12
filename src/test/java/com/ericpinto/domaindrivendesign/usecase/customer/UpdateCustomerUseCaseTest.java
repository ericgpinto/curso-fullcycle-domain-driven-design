package com.ericpinto.domaindrivendesign.usecase.customer;

import com.ericpinto.domaindrivendesign.domain.customer.entity.Customer;
import com.ericpinto.domaindrivendesign.domain.customer.entity.valueobject.Address;
import com.ericpinto.domaindrivendesign.domain.customer.factory.CustomerFactory;
import com.ericpinto.domaindrivendesign.domain.customer.repository.CustomerRepository;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UpdateCustomerUseCaseTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private UpdateCustomerUseCase updateCustomerUseCase;

    Customer customer;
    InputUpdateCustomerDTO input;

    @BeforeEach
    void setUp() {
        customer = CustomerFactory.createWithAddress("John",
                new Address("Street", "city", "zip", 123));

        input = new InputUpdateCustomerDTO(
                customer.getId(),
                "John Updated",
                "Street Updated",
                "city updated",
                "zip updated",
                1234
        );
    }

    @Test
    void shouldUpdateCustomer() {
        Mockito.when(customerRepository.findById(customer.getId())).thenReturn(customer);
        OutputUpdateCustomerDTO output = updateCustomerUseCase.execute(input);
        assertEquals(output.name(), input.name());
    }
}
