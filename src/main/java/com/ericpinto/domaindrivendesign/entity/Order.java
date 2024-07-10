package com.ericpinto.domaindrivendesign.entity;

import java.util.List;

public class Order {

    private String id;
    private String customerId;
    private List<OrderItem> items;

    public Order(String id, String customerId, List<OrderItem> items) {
        this.id = id;
        this.customerId = customerId;
        this.items = items;
    }
}
