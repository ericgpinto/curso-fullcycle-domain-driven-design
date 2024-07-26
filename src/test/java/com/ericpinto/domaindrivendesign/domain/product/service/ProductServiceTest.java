package com.ericpinto.domaindrivendesign.domain.product.service;

import com.ericpinto.domaindrivendesign.domain.product.entity.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class ProductServiceTest {
    private static final String ID = "123";
    private static final String NAME = "product name";
    private static final Integer PRICE = 10;

    Product product = new Product(ID, NAME, PRICE);
    Product product2 = new Product("456", "product2", 20);
    List<Product> products = Arrays.asList(product, product2);

    @Test
    void shouldChangePricesOfAllProducts() {
        ProductService.increasePrice(products, 100);

        Assertions.assertEquals(product.getPrice(), 20);
        Assertions.assertEquals(product2.getPrice(), 40);
    }

}
