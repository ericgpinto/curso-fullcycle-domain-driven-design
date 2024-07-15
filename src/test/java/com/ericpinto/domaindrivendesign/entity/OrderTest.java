package com.ericpinto.domaindrivendesign.entity;

import com.ericpinto.domaindrivendesign.domain.entity.Order;
import com.ericpinto.domaindrivendesign.domain.entity.OrderItem;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderTest {

    static final String ID = "123";
    static final String CUSTOMER_ID = "123";
    static final String EXPECTED_MESSAGE_ID = "Id is required";
    static final String EXPECTED_MESSAGE_CUSTOMER_ID = "CustomerId is required";
    static final String EXPECTED_MESSAGE_ITEMS = "Item quantity cannot be empty";


    @Test
    void shouldThrowErrorWhenIdIsEmpty(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
           new Order("", CUSTOMER_ID, List.of());
        });

        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(EXPECTED_MESSAGE_ID));
    }

    @Test
    void shouldThrowErrorWhenCustomerIdIsEmpty(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Order(ID, "", List.of());
        });

        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(EXPECTED_MESSAGE_CUSTOMER_ID));
    }

    @Test
    void shouldThrowErrorWhenItemsAreEmpty(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Order(ID, CUSTOMER_ID, Collections.emptyList());
        });

        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(EXPECTED_MESSAGE_ITEMS));
    }

    @Test
    void shouldCalculateTotal (){
        OrderItem orderItem = new OrderItem("123", "Item 1", 100, "456", 1);
        OrderItem orderItem2 = new OrderItem("456", "Item 2", 200, "789", 3);

        Order order = new Order(ID, CUSTOMER_ID, List.of(orderItem));
        Order order2 = new Order(ID, CUSTOMER_ID, List.of(orderItem, orderItem2));

        Integer total = order2.total();

        assertEquals(total, 700);
    }

    @Test
    void shouldThrowIfTheItemQuantityIsLessOrEqualZero (){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            OrderItem orderItem = new OrderItem("123", "Item 1", 100, "456", 0);
            new Order(ID, CUSTOMER_ID, List.of(orderItem));
        });

        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains("Item quantity must be greater than zero"));

    }



}