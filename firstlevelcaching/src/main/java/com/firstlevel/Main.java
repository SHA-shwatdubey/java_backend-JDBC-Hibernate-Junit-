//package com.firstlevel;
//
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.EntityTransaction;
//import jakarta.persistence.Persistence;
//
//public class Main {
//	
//	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql");
//	
//	public static void main(String[] args) {
////		insert();
//		read();
//	}
//	
//	public static void insert() {
//		
//		EntityManager em = emf.createEntityManager();
//		EntityTransaction et = em.getTransaction();
//		
//		Product1 p1 = new Product1(1, "Book");
//		Product1 p2 = new Product1(2, "Pencil");
//		
//		et.begin();
//		em.persist(p2);
//		em.persist(p1);
//		et.commit();
//	}
//	
//	public static void read() {
//		EntityManager em = emf.createEntityManager();
//		EntityTransaction et = em.getTransaction();
//		
//		System.out.println("====================First cache====================");
//		Product1 p1 = em.find(Product1.class, 2);
//		System.out.println(p1.getName());
//		em.close();
//		
//		System.out.println("====================Second cache====================");
//		EntityManager em1 = emf.createEntityManager();
//		Product1 p2 = em1.find(Product1.class, 2); 
//		System.out.println(p2.getName());
//		
//		// here only one time create and second time wont create after creating
//		// another em then only 2 different reads for different user so much
////		/ times it is reading db it is bad then use second level cache
//		
//	}
//	
//}
