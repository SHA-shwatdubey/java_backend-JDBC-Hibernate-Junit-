package com.sales.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import com.sales.model.Order;
import com.sales.model.Product;

public class OrderService {

    private EntityManager em;

    public OrderService(EntityManager em) {
        this.em = em;
    }

    public void placeOrder(Order order) {

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        double total = 0;
        for(Product p : order.getProducts()) {
            total += p.getPrice();
        }

        order.setTotalAmount(total);

        order.setOrderDate(java.time.LocalDate.now().toString());

        em.persist(order);

        tx.commit();

        System.out.println("Order saved successfully");
    }
}