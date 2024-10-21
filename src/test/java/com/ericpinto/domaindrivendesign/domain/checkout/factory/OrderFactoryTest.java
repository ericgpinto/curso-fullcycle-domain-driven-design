package com.ericpinto.domaindrivendesign.domain.checkout.factory;

import com.ericpinto.domaindrivendesign.domain.checkout.entity.Order;
import com.ericpinto.domaindrivendesign.domain.checkout.entity.OrderItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;

@SpringBootTest
class OrderFactoryTest {

    @Test
    void shouldCreateOrder(){
        OrderItem orderItem = new OrderItem(UUID.randomUUID().toString(), "Product 1", 123, UUID.randomUUID().toString(), 2);
        var orderProps = new Order(UUID.randomUUID().toString(), UUID.randomUUID().toString(), List.of(orderItem));

        Order order = OrderFactory.create(orderProps);

        Assertions.assertEquals(order.getId(), orderProps.getId());
        Assertions.assertEquals(order.getCustomerId(), orderProps.getCustomerId());
        Assertions.assertEquals(1, order.getItems().size());
    }
}
