package com.sales.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import com.sales.model.SupportTicket;

public class TicketService {

    private EntityManager em;

    public TicketService(EntityManager em) {
        this.em = em;
    }

    public void createTicket(SupportTicket t) {

        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.persist(t);
        tx.commit();

        System.out.println("Ticket created");
    }
}