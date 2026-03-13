package pom.capgemini;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository repository;

    @Autowired
    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public void printStudents() {
        System.out.println("Students (via @Service -> @Repository):");
        for (Student student : repository.findAll()) {
            System.out.println(student);
        }
    }
}

