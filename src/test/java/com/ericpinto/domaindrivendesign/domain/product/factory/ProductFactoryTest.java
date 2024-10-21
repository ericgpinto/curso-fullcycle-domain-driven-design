package com.ericpinto.domaindrivendesign.domain.product.factory;

import static org.junit.jupiter.api.Assertions.*;

import com.ericpinto.domaindrivendesign.domain.checkout.entity.Order;
import com.ericpinto.domaindrivendesign.domain.product.entity.IProduct;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ProductFactoryTest {

    @Test
    void shouldCreateProductTypeA() {
        IProduct product = ProductFactory.create("a", "Product A", 1);

        assertNotNull(product.getId());
        assertEquals("Product A", product.getName());
        assertEquals(1, product.getPrice());
    }

    @Test
    void shouldCreateProductTypeB() {
        IProduct product = ProductFactory.create("b", "Product B", 1);

        assertNotNull(product.getId());
        assertEquals("Product B", product.getName());
        assertEquals(2, product.getPrice());
    }

    @Test
    void shouldThrowAnErrorWhenProductTypeIsNotSupported() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ProductFactory.create("c", "Product C", 1);
        });

        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains("Unknown product type: "));
    }
}
