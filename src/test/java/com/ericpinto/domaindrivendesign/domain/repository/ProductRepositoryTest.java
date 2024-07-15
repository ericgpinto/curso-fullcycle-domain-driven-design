package com.ericpinto.domaindrivendesign.domain.repository;

import com.ericpinto.domaindrivendesign.infrastructure.db.model.ProductModel;
import com.ericpinto.domaindrivendesign.infrastructure.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@DataJpaTest(showSql = true)
@EnableJpaRepositories
class ProductRepositoryTest {

    private ProductRepository productRepository;

    private static final String ID = "123";
    private static final String NAME = "Product Name";
    private static final Integer PRICE = 100;
    ProductModel product = new ProductModel(ID, NAME, PRICE);

    @BeforeEach
    void setUp() {
        productRepository = mock(ProductRepository.class);
    }

    @Test
    void shouldCreateAProduct(){
        productRepository.save(product);

        verify(productRepository).save(product);
    }

    @Test
    void shouldUpdateAProduct(){
        when(productRepository.findById("123")).thenReturn(Optional.of(product));

        ProductModel productFound = productRepository.findById("123").get();

        productFound.setName("Product 2");
        productFound.setPrice(200);

        productRepository.save(productFound);

        verify(productRepository).save(product);

        assertEquals(product.getName(), "Product 2");
        assertEquals(product.getPrice(), 200);
    }

    @Test
    void shouldFindAProduct(){
        when(productRepository.findById("123")).thenReturn(Optional.of(product));

        ProductModel found = productRepository.findById("123").get();

        assertEquals(product, found);
    }

    @Test
    void shouldFindAllProducts(){
        ProductModel product2 = new ProductModel("456", "Product 2", 300);
        when(productRepository.findAll()).thenReturn(List.of(product, product2));

        List<ProductModel> products = productRepository.findAll();

        assertEquals(products.size(), 2);
        assertEquals(products.get(0), product);
        assertEquals(products.get(1), product2);
    }


}
