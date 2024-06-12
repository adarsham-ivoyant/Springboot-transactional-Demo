package com.ivoyant.springboottransactionaldemo.repository;

import com.ivoyant.springboottransactionaldemo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
