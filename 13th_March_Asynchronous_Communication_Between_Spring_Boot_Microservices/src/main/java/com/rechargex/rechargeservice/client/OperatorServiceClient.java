package com.rechargex.rechargeservice.client;

public interface OperatorServiceClient {
    PlanDetails validatePlan(Long operatorId, Long planId);
}

