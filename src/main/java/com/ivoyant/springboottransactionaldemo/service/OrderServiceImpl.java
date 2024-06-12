package com.ivoyant.springboottransactionaldemo.service;

import com.ivoyant.springboottransactionaldemo.dto.OrderRequest;
import com.ivoyant.springboottransactionaldemo.dto.OrderResponse;
import com.ivoyant.springboottransactionaldemo.entity.Order;
import com.ivoyant.springboottransactionaldemo.entity.Payment;
import com.ivoyant.springboottransactionaldemo.exception.PaymentException;
import com.ivoyant.springboottransactionaldemo.repository.OrderRepository;
import com.ivoyant.springboottransactionaldemo.repository.PaymentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;


@Service
public class OrderServiceImpl implements OrderService{

    private OrderRepository orderRepository;
    private PaymentRepository paymentRepository;

    public OrderServiceImpl(OrderRepository orderRepository, PaymentRepository paymentRepository) {
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
    }

    @Override
    @Transactional
    public OrderResponse placeOrder(OrderRequest orderRequest) {

        Order order = orderRequest.getOrder();
        order.setStatus("INPROGRESS");
        order.setOrderTackingNumber(UUID.randomUUID().toString());
        orderRepository.save(order);

        Payment payment = orderRequest.getPayment();

        if(!payment.getType().equals("DEBIT")){
            throw new PaymentException("Payment card type do not support");
        }

        payment.setOrderId(order.getId());
        paymentRepository.save(payment);

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderTackingNumber(order.getOrderTackingNumber());
        orderResponse.setStatus(order.getStatus());
        orderResponse.setMessage("SUCCESS");
        return orderResponse;
    }
}
