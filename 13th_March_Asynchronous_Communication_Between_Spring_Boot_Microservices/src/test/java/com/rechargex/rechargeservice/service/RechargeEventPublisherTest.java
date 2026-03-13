package com.rechargex.rechargeservice.service;

import com.rechargex.rechargeservice.config.RabbitMQConfig;
import com.rechargex.rechargeservice.dto.RechargeSuccessEvent;
import com.rechargex.rechargeservice.entity.RechargeEntity;
import com.rechargex.rechargeservice.entity.enums.RechargeStatus;
import com.rechargex.rechargeservice.repository.RechargeRepository;
import com.rechargex.rechargeservice.client.PlanDetails;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.amqp.core.AmqpTemplate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RechargeEventPublisherTest {

    @Mock
    private RechargeRepository rechargeRepository;

    @Mock
    private AmqpTemplate amqpTemplate;

    @InjectMocks
    private RechargeEventPublisher rechargeEventPublisher;

    @Test
    void shouldPublishAndMarkEventPublished() {
        RechargeEntity entity = RechargeEntity.builder()
                .id(100L)
                .userId(2L)
                .mobileNumber("9876543210")
                .operatorId(1L)
                .planId(9L)
                .amount(BigDecimal.valueOf(299))
                .status(RechargeStatus.SUCCESS)
                .transactionId("TXN-1")
                .completedAt(LocalDateTime.now())
                .eventPublished(false)
                .build();

        PlanDetails plan = PlanDetails.builder()
                .operatorName("Airtel")
                .planName("Unlimited")
                .validityDays(28)
                .build();

        when(rechargeRepository.findById(100L)).thenReturn(Optional.of(entity));

        rechargeEventPublisher.publishAfterCommit(new RechargeCreatedInternalEvent(100L, "u@test.com", plan));

        ArgumentCaptor<RechargeSuccessEvent> eventCaptor = ArgumentCaptor.forClass(RechargeSuccessEvent.class);
        verify(amqpTemplate, times(1)).convertAndSend(eq(RabbitMQConfig.EXCHANGE_NAME), eq(RabbitMQConfig.ROUTING_KEY), eventCaptor.capture());
        assertEquals(100L, eventCaptor.getValue().getRechargeId());
        assertEquals(true, entity.getEventPublished());
        verify(rechargeRepository, times(1)).save(entity);
    }
}
