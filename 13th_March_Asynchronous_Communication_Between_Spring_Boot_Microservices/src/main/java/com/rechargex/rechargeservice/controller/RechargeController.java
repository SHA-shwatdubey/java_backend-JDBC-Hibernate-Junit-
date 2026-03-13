package com.rechargex.rechargeservice.controller;

import com.rechargex.rechargeservice.dto.RechargeRequestDTO;
import com.rechargex.rechargeservice.dto.RechargeResponseDTO;
import com.rechargex.rechargeservice.security.AuthenticatedUser;
import com.rechargex.rechargeservice.service.RechargeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/recharge")
public class RechargeController {

    private final RechargeService rechargeService;

    public RechargeController(RechargeService rechargeService) {
        this.rechargeService = rechargeService;
    }

    @PostMapping("/")
    public ResponseEntity<RechargeResponseDTO> initiateRecharge(
            @Valid @RequestBody RechargeRequestDTO request,
            @AuthenticationPrincipal AuthenticatedUser authenticatedUser
    ) {
        RechargeResponseDTO response = rechargeService.initiateRecharge(request, authenticatedUser.getUserId());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }
}

