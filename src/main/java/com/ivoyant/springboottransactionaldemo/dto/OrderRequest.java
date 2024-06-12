package com.ivoyant.springboottransactionaldemo.dto;

import com.ivoyant.springboottransactionaldemo.entity.Order;
import com.ivoyant.springboottransactionaldemo.entity.Payment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {
    private Order order;
    private Payment payment;
}
