package com.ericpinto.domaindrivendesign.infrastructure.order.repository;

import com.ericpinto.domaindrivendesign.infrastructure.order.model.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderModel, String> {
}
