package com.ivoyant.springboottransactionaldemo.exception;

public class PaymentException extends RuntimeException {
    public PaymentException(String message){
        super(message);
    }
}
