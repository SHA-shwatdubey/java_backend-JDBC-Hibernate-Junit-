package com.sales.service;

import com.sales.model.Customer;
import com.sales.model.Lead;
import com.sales.model.SalesEmployee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class LeadService {
	
	private EntityManager em;
	
	public LeadService(EntityManager em) {
		this.em = em;
	}
	
	
	public void createLead(Lead lead) {
		
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.persist(lead);
		et.commit();
		
	}
	
	public void assignLead(long leadId, int employeeId) {

        EntityTransaction et = em.getTransaction();

            et.begin();

            Lead lead = em.find(Lead.class, leadId);
            SalesEmployee emp = em.find(SalesEmployee.class, employeeId);

            if(lead != null && emp != null) {
                lead.setEmployee(emp);   
            }

            et.commit();
       
    }
	
	
	public void convertLead(int leadId) {

        EntityTransaction et = em.getTransaction();

        
        et.begin();

            Lead lead = em.find(Lead.class, leadId);

            if(lead != null) {

                Customer c = new Customer();
                c.setName(lead.getName());
                c.setEmail(lead.getContactInfo());

                em.persist(c);

                em.remove(lead);
            }

            et.commit();
       
    }

	
}
