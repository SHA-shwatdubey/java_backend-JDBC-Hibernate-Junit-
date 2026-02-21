package com.sales.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	
	@Id
	@GeneratedValue
	private int id;
	private String orderDate;
	private double totalAmount;
	
	
	public Order() {}


	public Order(int id, String orderDate, double totalAmount) {
		super();
		this.id = id;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
	}
	
    @ManyToOne
    private Customer customers;

    @ManyToMany
    private List<Product> products;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}


	public double getTotalAmount() {
		return totalAmount;
	}


	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}


	public Customer getCustomers() {
		return customers;
	}


	public void setCustomers(Customer customers) {
		this.customers = customers;
	}


	public List<Product> getProducts() {
		return products;
	}


	public void setProducts(List<Product> products) {
		this.products = products;
	}

    
    
	
}
