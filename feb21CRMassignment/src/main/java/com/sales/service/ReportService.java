package com.sales.service;

import jakarta.persistence.EntityManager;
import java.util.List;
import com.sales.model.Order;

public class ReportService {

    private EntityManager em;

    public ReportService(EntityManager em) {
        this.em = em;
    }

    public List<Order> getOrdersAbove(double amount) {

        return em.createQuery(
                "SELECT o FROM Order o WHERE o.totalAmount > :amt",
                Order.class)
                .setParameter("amt", amount)
                .getResultList();
    }
}