package com.rechargex.rechargeservice.client.impl;

import com.rechargex.rechargeservice.client.OperatorServiceClient;
import com.rechargex.rechargeservice.client.PlanDetails;
import com.rechargex.rechargeservice.exception.PlanNotFoundException;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class OperatorServiceClientImpl implements OperatorServiceClient {

    @Override
    public PlanDetails validatePlan(Long operatorId, Long planId) {
        if (operatorId == null || operatorId < 1 || planId == null || planId < 1) {
            throw new PlanNotFoundException("Invalid operator or plan");
        }
        return PlanDetails.builder()
                .operatorId(operatorId)
                .planId(planId)
                .operatorName("DefaultOperator")
                .planName("Standard Plan")
                .amount(BigDecimal.valueOf(199))
                .validityDays(28)
                .build();
    }
}

