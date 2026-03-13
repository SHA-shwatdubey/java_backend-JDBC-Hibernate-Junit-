package com.bidirect;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Main {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Student s1 = new Student(1, "miller", "cse");
		Student s2 = new Student(2, "rohith", "ece");
		
		Subject sub1 = new Subject(100, "telugu");
		Subject sub2 = new Subject(101, "machine learning");
		Subject sub3 = new Subject(103, "software engineering");
		
//		List<Student> stu = List.of(s1, s2);
//		List<Subject> sub = List.of(sub1, sub2, sub3);
//		
//		// student --> subject
//		s1.setSubjects(sub);
//		s2.setSubjects(sub);
//		
//		// subject -- > student
//		sub1.setStudents(stu);
//		sub2.setStudents(stu);
//		sub3.setStudents(stu);
//		
//		et.begin();
//		em.persist(s1);
//		em.persist(s2);
//		et.commit();
//		
//		em.close();
//		
	}
}
