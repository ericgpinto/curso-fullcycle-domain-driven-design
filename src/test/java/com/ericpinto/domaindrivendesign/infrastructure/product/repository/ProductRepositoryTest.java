package com.ericpinto.domaindrivendesign.infrastructure.product.repository;

import com.ericpinto.domaindrivendesign.infrastructure.product.model.ProductModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

@DataJpaTest
class ProductRepositoryTest {

    private ProductRepository productRepository;
    private static final String ID = "123";
    private static final String NAME = "Product 1";
    private static final Integer PRICE = 100;

    ProductModel productModel = new ProductModel(ID, NAME, PRICE);

    @BeforeEach
    void setUp() {
        productRepository = Mockito.mock(ProductRepository.class);
    }

    @Test
    void shouldCreateProduct() {
        productRepository.save(productModel);

        Mockito.verify(productRepository, Mockito.times(1)).save(productModel);
    }

    @Test
    void shouldUpdateProduct() {
        Mockito.when(productRepository.findById(ID)).thenReturn(Optional.of(productModel));
        productModel.setName("Product 2");

        productRepository.save(productModel);

        Mockito.verify(productRepository, Mockito.times(1)).save(productModel);
        Assertions.assertEquals(productModel.getName(), "Product 2");
    }

    @Test
    void shouldFindAProduct(){
        Mockito.when(productRepository.findById(ID)).thenReturn(Optional.of(productModel));

        ProductModel productFounded = productRepository.findById(ID).get();

        Assertions.assertEquals(productFounded.getId(), productModel.getId());
        Assertions.assertEquals(productFounded.getName(), productModel.getName());
        Assertions.assertEquals(productFounded.getPrice(), productModel.getPrice());
    }

    @Test
    void shouldFindAllProducts(){
        ProductModel product2 = new ProductModel("456", "Product 2", 100);

        Mockito.when(productRepository.findAll()).thenReturn(List.of(productModel, product2));

        List<ProductModel> products = productRepository.findAll();

        Assertions.assertEquals(2, products.size());
        Assertions.assertEquals(productModel, products.get(0));
        Assertions.assertEquals(product2, products.get(1));

    }



}