package com.ericpinto.domaindrivendesign.service;

import com.ericpinto.domaindrivendesign.domain.entity.Customer;
import com.ericpinto.domaindrivendesign.domain.entity.Order;
import com.ericpinto.domaindrivendesign.domain.entity.OrderItem;
import com.ericpinto.domaindrivendesign.domain.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class OrderServiceTest {

    OrderItem orderItem = new OrderItem("456", "item 1", 100, "1", 1);
    OrderItem orderItem2 = new OrderItem("659", "item 1", 200, "2", 2);
    OrderItem orderItem3 = new OrderItem("156", "item 3", 300, "3", 3);
    OrderItem orderItem4 = new OrderItem("789", "item 4", 400, "4", 4);

    List<OrderItem> firstOrderItems = Arrays.asList(orderItem, orderItem2);
    List<OrderItem> secondOrderItems = Arrays.asList(orderItem3, orderItem4);

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
    void shouldGetTotalOfAllOrders() {
        Integer total = OrderService.total(orders);
        assertEquals(total, 3000);
    }

}
