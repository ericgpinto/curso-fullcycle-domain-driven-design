package com.ericpinto.domaindrivendesign.entity;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private String id;
    private String customerId;
    private List<OrderItem> items;
    private Integer total;

    public Order(String id, String customerId, List<OrderItem> items) {
        this.id = id;
        this.customerId = customerId;
        this.items = items;
        this.total = total();
        this.validate();
    }

    public void validate(){
        if (this.id.isEmpty()){
            throw new IllegalArgumentException("Id is required");
        }
        if (customerId.isEmpty()){
            throw new IllegalArgumentException("CustomerId is required");
        }

        if (items.isEmpty()){
            throw new IllegalArgumentException("Item quantity cannot be empty");
        }
    }

    public Integer total() {
        return this.items.
                stream()
                .reduce(0, (acc, item) -> acc + item.getPrice(), Integer::sum);
    }


}
