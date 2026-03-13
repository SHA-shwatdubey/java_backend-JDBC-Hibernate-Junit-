package com.rechargex.rechargeservice.service;

import com.rechargex.rechargeservice.config.RabbitMQConfig;
import com.rechargex.rechargeservice.dto.RechargeSuccessEvent;
import com.rechargex.rechargeservice.entity.RechargeEntity;
import com.rechargex.rechargeservice.repository.RechargeRepository;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class RechargeEventPublisher {

    private final RechargeRepository rechargeRepository;
    private final AmqpTemplate amqpTemplate;

    public RechargeEventPublisher(RechargeRepository rechargeRepository, AmqpTemplate amqpTemplate) {
        this.rechargeRepository = rechargeRepository;
        this.amqpTemplate = amqpTemplate;
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void publishAfterCommit(RechargeCreatedInternalEvent event) {
        RechargeEntity entity = rechargeRepository.findById(event.rechargeId())
                .orElseThrow(() -> new IllegalStateException("Recharge not found after commit"));

        RechargeSuccessEvent payload = RechargeSuccessEvent.fromEntity(
                entity,
                event.userEmail(),
                event.planDetails().getOperatorName(),
                event.planDetails().getPlanName(),
                event.planDetails().getValidityDays()
        );

        amqpTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, RabbitMQConfig.ROUTING_KEY, payload);
        entity.setEventPublished(true);
        rechargeRepository.save(entity);
    }
}
