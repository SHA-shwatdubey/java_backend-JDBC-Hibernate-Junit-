package pom.capgemini;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

    @Value("${student.default.city:Indore}")
    private String defaultCity;

    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Asha", defaultCity));
        students.add(new Student(2, "Rohit", "Bhopal"));
        students.add(new Student(3, "Meena", defaultCity));
        return students;
    }
}

