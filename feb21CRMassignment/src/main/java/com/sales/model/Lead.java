package com.sales.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "leads")
public class Lead {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String source;
	private String contactInfo;
	
	
	public Lead() {}


	public Lead(int id, String name, String source, String contactInfo) {
		super();
		this.id = id;
		this.name = name;
		this.source = source;
		this.contactInfo = contactInfo;
	}
	
	@ManyToOne
	private SalesEmployee employee;


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


	public String getSource() {
		return source;
	}


	public void setSource(String source) {
		this.source = source;
	}


	public String getContactInfo() {
		return contactInfo;
	}


	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}


	public SalesEmployee getEmployee() {
		return employee;
	}


	public void setEmployee(SalesEmployee employee) {
		this.employee = employee;
	}


	@Override
	public String toString() {
		return "Lead [id=" + id + ", name=" + name + ", source=" + source + ", contactInfo=" + contactInfo
				+ ", employee=" + employee + "]";
	}
	
	
	
	
	
}
