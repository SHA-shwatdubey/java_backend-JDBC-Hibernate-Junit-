package com.user_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="amazon_user_info")
public class UserInformation {
	
	@Id
	private String emailId;
	private String password;
	private String fullname;
	
	public UserInformation() {
	}
	
	public UserInformation(String emailId, String password, String fullname) {
		this.emailId = emailId;
		this.password = password;
		this.fullname = fullname;
	}
	

	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	@Override
	public String toString() {
		return "UserInformation [emailId=" + emailId + ", password=" + password + ", fullname=" + fullname + "]";
	}

	
}
