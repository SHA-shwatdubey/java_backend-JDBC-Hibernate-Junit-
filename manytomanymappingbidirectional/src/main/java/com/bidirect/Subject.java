package com.bidirect;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "subjects")
public class Subject {
	
	@Id
	private int id;
	private String name;
	
	public Subject() {}
	
	public Subject(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	@ManyToMany(mappedBy = "subjects")
	private List<Student> students;
	
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

	

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Subject [id=" + id + ", name=" + name + ", students=" + students + "]";
	}
	
	
	
	
}
