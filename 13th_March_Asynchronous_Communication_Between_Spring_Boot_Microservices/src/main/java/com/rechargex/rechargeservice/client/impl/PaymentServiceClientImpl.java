package com.rechargex.rechargeservice.client.impl;

import com.rechargex.rechargeservice.client.PaymentResult;
import com.rechargex.rechargeservice.client.PaymentServiceClient;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class PaymentServiceClientImpl implements PaymentServiceClient {

    @Override
    public PaymentResult charge(Long userId, BigDecimal amount, String paymentMethod, String transactionId) {
        if (amount == null || amount.signum() <= 0) {
            return PaymentResult.builder()
                    .success(false)
                    .failureReason("Invalid payment amount")
                    .build();
        }
        return PaymentResult.builder()
                .success(true)
                .paymentId(Math.abs(transactionId.hashCode()) + 0L)
                .build();
    }
}

