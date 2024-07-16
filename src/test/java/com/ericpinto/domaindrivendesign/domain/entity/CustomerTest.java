package com.ericpinto.domaindrivendesign.domain.entity;

import static org.junit.jupiter.api.Assertions.*;

import com.ericpinto.domaindrivendesign.domain.entity.Address;
import com.ericpinto.domaindrivendesign.domain.entity.Customer;
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

    @Test
    void shouldAddRewardPoints(){
        Customer customer = new Customer("123", "John");
        Customer customer2 = new Customer("456", "Chris");
        Customer customer3 = new Customer("789", "Erick");

        customer2.addRewardPoints(10);
        customer3.addRewardPoints(20);

        assertEquals(customer.getRewardPoints(), 0);
        assertEquals(customer2.getRewardPoints(), 10);
        assertEquals(customer3.getRewardPoints(), 20);
    }



}