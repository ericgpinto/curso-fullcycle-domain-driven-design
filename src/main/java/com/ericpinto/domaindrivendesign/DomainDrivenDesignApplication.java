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

    }

}
