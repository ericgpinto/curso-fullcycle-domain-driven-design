package com.ericpinto.domaindrivendesign.entity;

public class OrderItem {

    private String id;
    private String name;
    private Integer price;

    public OrderItem(String id, String name, Integer price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
