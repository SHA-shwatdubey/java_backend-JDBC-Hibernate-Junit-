package com.prac;

public class Employee {
	
	private int id;
	private String name;
	private int age;
	private String dept;
	
	public Employee() {}
	
	public Employee(int id, String name, int age, String dept) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.dept = dept;
	}

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
	
	
	public boolean isValidAge() {
		if(age >= 18) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean isValidName() {
		
		if(name == null || name.length() <= 1) {
			return false;
		}
		
		for(int i = 0;i < name.length(); i++) {
			char ch = name.charAt(i);
			if(!Character.isLetter(ch)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean checkDept() {
		
		if (dept == null || dept.length() <= 1) {
	        return false;
	    }
		
		for(int i = 0;i < dept.length(); i++) {
			char ch = dept.charAt(i);
			if(!Character.isLetter(ch)) {
				return false;
			}
		}
		return true;
		
		
	}
	
	
}
