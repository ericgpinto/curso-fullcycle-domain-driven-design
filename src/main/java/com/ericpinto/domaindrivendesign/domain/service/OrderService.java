package com.ericpinto.domaindrivendesign.domain.service;

import com.ericpinto.domaindrivendesign.domain.entity.Customer;
import com.ericpinto.domaindrivendesign.domain.entity.Order;
import com.ericpinto.domaindrivendesign.domain.entity.OrderItem;

import java.util.List;
import java.util.UUID;

public class OrderService {

    public static Order placeOrder (Customer customer, List<OrderItem> orderItems){

        if (orderItems.isEmpty()){
            throw new IllegalArgumentException("Order must have at least one item");
        }
        Order order = new Order(UUID.randomUUID().toString(), customer.getId(), orderItems);
        customer.addRewardPoints(order.total() / 2);
        return order;
    }

    public static Integer total(List<Order> orders) {
        return orders
                .stream()
                .reduce(0, (acc, order) -> acc + order.total(), Integer::sum);
    }
}
