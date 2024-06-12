package com.ivoyant.springboottransactionaldemo.service;

import com.ivoyant.springboottransactionaldemo.dto.OrderRequest;
import com.ivoyant.springboottransactionaldemo.dto.OrderResponse;

public interface OrderService {
    OrderResponse placeOrder(OrderRequest orderRequest);
}
