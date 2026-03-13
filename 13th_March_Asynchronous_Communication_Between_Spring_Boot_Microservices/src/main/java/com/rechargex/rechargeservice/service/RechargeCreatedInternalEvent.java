package com.rechargex.rechargeservice.service;

import com.rechargex.rechargeservice.client.PlanDetails;

public record RechargeCreatedInternalEvent(Long rechargeId, String userEmail, PlanDetails planDetails) {
}

