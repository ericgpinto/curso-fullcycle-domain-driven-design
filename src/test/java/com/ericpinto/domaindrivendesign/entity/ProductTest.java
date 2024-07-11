package com.ericpinto.domaindrivendesign.entity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductTest {

    static final String ID = "123";
    static final String NAME = "Product 1";
    static final Integer PRICE = 100;
    static final String EXPECTED_MESSAGE_ID = "Id is required";
    static final String EXPECTED_MESSAGE_NAME = "Name is required";
    static final String EXPECTED_MESSAGE_PRICE = "Price must be greater than 0";


    @Test
    void shouldThrowErrorWhenIdIsEmpty(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Product("", NAME, PRICE);
        });

        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(EXPECTED_MESSAGE_ID));
    }

    @Test
    void shouldThrowErrorWhenNameIsEmpty(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Product(ID, "", PRICE);
        });

        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(EXPECTED_MESSAGE_NAME));
    }

    @Test
    void shouldThrowErrorWhenPriceIsLessThanZero(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Product(ID, NAME, -5);
        });

        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(EXPECTED_MESSAGE_PRICE));
    }

    @Test
    void shouldChangeName(){
        Product product = new Product(ID, NAME, PRICE);
        product.changeName("Product 2");
        assertEquals(product.getName(), "Product 2");
    }

    @Test
    void shouldChangePrice(){
        Product product = new Product(ID, NAME, PRICE);
        product.changePrice(150);
        assertEquals(product.getPrice(), 150);
    }



}