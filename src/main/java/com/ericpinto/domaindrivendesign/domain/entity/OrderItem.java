package com.ericpinto.domaindrivendesign.domain.entity;

public class OrderItem {

    private String id;
    private String productId;
    private String name;
    private Integer price;
    private Integer quantity;

    public OrderItem(String id, String name, Integer price, String productId, Integer quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.productId = productId;
        this.quantity = quantity;
    }

    public Integer getPrice() {
        return price * quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
