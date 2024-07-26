package com.ericpinto.domaindrivendesign.infrastructure.order.repository;

import com.ericpinto.domaindrivendesign.infrastructure.customer.model.CustomerModel;
import com.ericpinto.domaindrivendesign.infrastructure.order.model.OrderItemModel;
import com.ericpinto.domaindrivendesign.infrastructure.order.model.OrderModel;
import com.ericpinto.domaindrivendesign.infrastructure.product.model.ProductModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@DataJpaTest
class OrderRepositoryTest {

    private OrderRepository orderRepository;

    CustomerModel customerModel = new CustomerModel("123", "Customer 1", "Rua A", 12, "POA",
            "91220", true, 0);
    ProductModel productModel = new ProductModel("123", "Product 1", 200);
    OrderItemModel orderItemModel = new OrderItemModel("1", productModel, 0, "T", 200);

    OrderModel orderModel = new OrderModel("123", customerModel, List.of(orderItemModel),  200);

    OrderItemModel orderItemModel2 = new OrderItemModel("2", productModel, 1, "P", 400);

    @BeforeEach
    void setUp() {
        orderRepository = mock(OrderRepository.class);
    }

    @Test
    void shouldCreateOrder() {
        orderRepository.save(orderModel);

        verify(orderRepository, times(1)).save(orderModel);

        assertEquals(orderModel.getItems().get(0), orderItemModel);
        assertEquals(orderModel.getCustomer(), customerModel);
    }

    @Test
    @DisplayName("Should update order when add a new item")
    void shouldUpdateOrder() {
        orderModel.setItems(List.of(orderItemModel, orderItemModel2));
        orderRepository.save(orderModel);

        verify(orderRepository, times(1)).save(orderModel);
        assertEquals(orderModel.getItems().get(0), orderItemModel);
        assertEquals(orderModel.getItems().get(1), orderItemModel2);
    }
    @Test
    void shouldFindAOrder(){
        Mockito.when(orderRepository.findById("123")).thenReturn(Optional.of(orderModel));

        OrderModel orderFounded = orderRepository.findById("123").get();

        Assertions.assertEquals(orderFounded.getId(), productModel.getId());
        Assertions.assertEquals(orderFounded.getTotal(), orderModel.getTotal());
        Assertions.assertEquals(orderFounded.getCustomer(), orderModel.getCustomer());
    }

    @Test
    void shouldFindAllOrders(){
        OrderModel orderModel2 = new OrderModel("456", customerModel, List.of(orderItemModel2),  300);
        Mockito.when(orderRepository.findAll()).thenReturn(List.of(orderModel, orderModel2 ));

        List<OrderModel> orders = orderRepository.findAll();

        Assertions.assertEquals(2, orders.size());
    }



}