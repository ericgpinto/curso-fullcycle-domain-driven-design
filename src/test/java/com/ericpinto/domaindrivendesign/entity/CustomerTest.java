package com.ericpinto.domaindrivendesign.entity;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CustomerTest {

    @Test
    void shouldThrowErrorWhenIdIsEmpty(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Customer("", "John");
        });

        String expectedMessage = "Customer id is required";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void shouldThrowErrorWhenNameIsEmpty(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Customer("123", "");
        });

        String expectedMessage = "Customer name is required";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void shouldChangeName(){
        Customer customer = new Customer("123", "John");

        customer.changeName("Jane");

        assertEquals(customer.getName(), "Jane");

    }

    @Test
    void shouldActivateCustomer(){
        Customer customer = new Customer("123", "John");
        Address address = new Address("Rua dois", "Sao Paulo", "12345-678", 2);
        customer.setAddress(address);

        customer.activate();

        assertTrue(customer.isActive());
    }

    @Test
    void shouldThrowErrorWhenAddressIsEmpty(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Customer customer = new Customer("123", "John");
            customer.activate();
        });

        String expectedMessage = "Address is mandatory to activate a customer";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void shouldDeactivateCustomer(){
        Customer customer = new Customer("123", "John");

        customer.deactivate();

        assertFalse(customer.isActive());
    }



}