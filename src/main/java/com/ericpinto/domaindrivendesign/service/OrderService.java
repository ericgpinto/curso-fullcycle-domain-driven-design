package com.ericpinto.domaindrivendesign.service;

import com.ericpinto.domaindrivendesign.entity.Order;
import com.ericpinto.domaindrivendesign.entity.Product;

import java.util.List;

public class OrderService {

    public static Integer total(List<Order> orders) {
        return orders
                .stream()
                .reduce(0, (acc, order) -> acc + order.total(), Integer::sum);
    }
}
