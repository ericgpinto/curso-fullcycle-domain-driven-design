package com.ericpinto.domaindrivendesign.infrastructure.product.repository;

import com.ericpinto.domaindrivendesign.infrastructure.product.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, String> {
}
