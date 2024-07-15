package com.ericpinto.domaindrivendesign.domain.entity;

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

        if(this.items.stream().reduce(0, (acc, item) -> acc + item.getQuantity(), Integer::sum) <= 0){
            throw new IllegalArgumentException("Item quantity must be greater than zero");
        }
    }

    public Integer total() {
        return this.items.
                stream()
                .reduce(0, (acc, item) -> acc + item.getPrice(), Integer::sum);
    }


}
