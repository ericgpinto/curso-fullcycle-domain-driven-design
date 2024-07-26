package com.ericpinto.domaindrivendesign.domain.checkout.service;

import com.ericpinto.domaindrivendesign.domain.customer.entity.Customer;
import com.ericpinto.domaindrivendesign.domain.checkout.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class OrderServiceTest {

    Order.OrderItem orderItem = new Order.OrderItem("456", "item 1", 100, "1", 1);
    Order.OrderItem orderItem2 = new Order.OrderItem("659", "item 1", 200, "2", 2);
    Order.OrderItem orderItem3 = new Order.OrderItem("156", "item 3", 300, "3", 3);
    Order.OrderItem orderItem4 = new Order.OrderItem("789", "item 4", 400, "4", 4);

    List<Order.OrderItem> firstOrderItems = Arrays.asList(orderItem, orderItem2);
    List<Order.OrderItem> secondOrderItems = Arrays.asList(orderItem3, orderItem4);

    Order order = new Order("123", "125", firstOrderItems);
    Order order2 = new Order("3246", "125", secondOrderItems);

    List<Order> orders = Arrays.asList(order, order2);

    @Test
    void shouldPlaceAnOrder() {
        Customer customer = new Customer("123", "Éric");
        Order order = OrderService.placeOrder(customer, firstOrderItems);
        assertEquals(customer.getRewardPoints(), 250);
        assertEquals(order.total(), 500);
    }

    @Test
    void shouldThrowAnExceptionWhenItemsAreEmpty(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Customer customer = new Customer("123", "Éric");
            OrderService.placeOrder(customer, Collections.emptyList());
        });

        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains("Order must have at least one item"));
    }


    @Test
    void shouldGetTotalOfAllOrders() {
        Integer total = OrderService.total(orders);
        assertEquals(total, 3000);
    }

}
