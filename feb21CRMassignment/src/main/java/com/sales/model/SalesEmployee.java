package com.sales.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "salesemployee")
public class SalesEmployee {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String department;
	
	
	public SalesEmployee() {}


	public SalesEmployee(int id, String name, String department) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
	}
	
    @OneToMany(mappedBy="employee")
    private List<Lead> leads;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public List<Lead> getLeads() {
		return leads;
	}


	public void setLeads(List<Lead> leads) {
		this.leads = leads;
	}
    
    
    
	
}
