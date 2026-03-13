package pom.capgemini;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "college")
public class College {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "college_name")
    private String name;

    @OneToMany(mappedBy = "college", cascade = CascadeType.ALL)
    private List<Student> students = new ArrayList<>();

    public College() {}

    public College(String name) {
        this.name = name;
    }

    public void addStudent(Student student) {
        students.add(student);
        student.setCollege(this);
    }

    // Getters & Setters
    public int getId() { return id; }

    public String getName() { return name; }

    public List<Student> getStudents() { return students; }

    public void setName(String name) { this.name = name; }
}
