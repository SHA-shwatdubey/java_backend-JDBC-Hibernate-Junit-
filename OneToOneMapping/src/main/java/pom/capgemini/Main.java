package pom.capgemini;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("postgres");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Engine engine = new Engine("Petrol", 200);
        Car car = new Car("BMW", "X5", engine);

        em.persist(car);

        em.getTransaction().commit();

        em.close();
        emf.close();

        System.out.println("Data Saved Successfully!");
    }
}
