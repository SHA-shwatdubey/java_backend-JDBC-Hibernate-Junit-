package pom.capgemini;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class MainApp {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("collegePU");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        // College Object
        College college = new College("LPU");

        // ArrayList for Students
        List<Student> studentList = new ArrayList<>();

        studentList.add(new Student("Rahul"));
        studentList.add(new Student("Aman"));
        studentList.add(new Student("Priya"));
        studentList.add(new Student("Neha"));

        // Loop se students ko college me add karna
        for (Student s : studentList) {
            s.setCollege(college);   // foreign key set
        }

        // College ke students list me set karna
        college.getStudents().addAll(studentList);

        // Sirf college persist karenge
        em.persist(college);

        tx.commit();

        em.close();
        emf.close();

        System.out.println(" Data Inserted Using ArrayList!");
    }
}
