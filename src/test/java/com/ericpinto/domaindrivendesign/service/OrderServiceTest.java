package com.ericpinto.domaindrivendesign.service;

import com.ericpinto.domaindrivendesign.entity.Order;
import com.ericpinto.domaindrivendesign.entity.OrderItem;
import com.ericpinto.domaindrivendesign.entity.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class OrderServiceTest {
    private static final String ID = "123";
    private static final String NAME = "product name";
    private static final Integer PRICE = 10;

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
    void shouldGetTotalOfAllOrders() {
        Integer total = OrderService.total(orders);
        Assertions.assertEquals(total, 3000);
    }

}
