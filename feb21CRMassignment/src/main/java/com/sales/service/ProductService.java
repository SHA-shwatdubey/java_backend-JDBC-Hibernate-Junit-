package com.sales.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import com.sales.model.Product;

public class ProductService {

    private EntityManager em;

    public ProductService(EntityManager em) {
        this.em = em;
    }

    public void createProduct(Product p) {

        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.persist(p);
        tx.commit();

        System.out.println("Product created");
    }
}