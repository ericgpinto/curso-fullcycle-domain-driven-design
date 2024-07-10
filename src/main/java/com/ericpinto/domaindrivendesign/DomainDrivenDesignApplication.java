package com.ericpinto.domaindrivendesign;

import com.ericpinto.domaindrivendesign.entity.Address;
import com.ericpinto.domaindrivendesign.entity.Customer;
import com.ericpinto.domaindrivendesign.entity.Order;
import com.ericpinto.domaindrivendesign.entity.OrderItem;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class DomainDrivenDesignApplication {

    public static void main(String[] args) {
        SpringApplication.run(DomainDrivenDesignApplication.class, args);

        Customer customer = new Customer("123", "Eric Pinto");
        Address address = new Address("Rua dois", "Sao Paulo", "12345-678", 2);
        customer.setAddress(address);
        customer.activate();
        // ID

        // Objeto - Entidade
        OrderItem item1 = new OrderItem("1", "Item 1", 10);
        OrderItem item2 = new OrderItem("2", "Item 2", 15);
        Order order = new Order("1", "123", Arrays.asList(item1, item2));
    }

}
