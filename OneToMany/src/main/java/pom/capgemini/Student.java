package pom.capgemini;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "student_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "college_id")
    private College college;

    public Student() {}

    public Student(String name) {
        this.name = name;
    }

    // Getters & Setters
    public int getId() { return id; }

    public String getName() { return name; }

    public College getCollege() { return college; }

    public void setName(String name) { this.name = name; }

    public void setCollege(College college) {
        this.college = college;
    }
}
