package pom.capgemini;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class FetchDemo {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("postgres");

        EntityManager em = emf.createEntityManager();

        TypedQuery<Product> query =
                em.createQuery("SELECT p FROM Product p", Product.class);

        List<Product> list = query.getResultList();

        list.forEach(System.out::println);

        em.close();
        emf.close();
    }
}
