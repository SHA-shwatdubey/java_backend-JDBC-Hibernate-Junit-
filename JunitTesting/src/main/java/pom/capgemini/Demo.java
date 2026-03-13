package pom.capgemini;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Demo {

    public static void main(String[] args) {

        // IMPORTANT: must match persistence.xml
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("postgres");

        EntityManager em = emf.createEntityManager();

        EntityTransaction et = em.getTransaction();

        try {
            et.begin();

            Product p1 = new Product(1, "hero", 1000, 3);
            Product p2 = new Product(2, "Pen", 10, 10);
            Product p3 = new Product(3, "Pencil", 30, 10);
            Product p4 = new Product(4, "Notebook", 40, 10);
            Product p5 = new Product(5, "book", 20, 30);

            em.persist(p1);
            em.persist(p2);
            em.persist(p3);
            em.persist(p4);
            em.persist(p5);

            et.commit();

            System.out.println("Data Inserted Successfully ✅");

        } catch (Exception e) {
            et.rollback();
            e.printStackTrace();
        }

        em.close();
        emf.close();
    }
}
