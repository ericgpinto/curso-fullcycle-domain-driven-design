package com.ericpinto.domaindrivendesign.domain.checkout.factory;

import com.ericpinto.domaindrivendesign.domain.checkout.entity.Order;

public class OrderFactory {

    public static Order create(Order orderProps) {
        return new Order(orderProps.getId(), orderProps.getCustomerId(), orderProps.getItems());
    }
}
