package com.sales.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "support_ticket")
public class SupportTicket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String issueDescription;
	
	
	
	public SupportTicket() {}



	public SupportTicket(long id, String issueDescription) {
		super();
		this.id = id;
		this.issueDescription = issueDescription;
	}
	
    @ManyToOne
    private Order order;



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getIssueDescription() {
		return issueDescription;
	}



	public void setIssueDescription(String issueDescription) {
		this.issueDescription = issueDescription;
	}



	public Order getOrder() {
		return order;
	}



	public void setOrder(Order order) {
		this.order = order;
	}
    
    
    
	
	
}
