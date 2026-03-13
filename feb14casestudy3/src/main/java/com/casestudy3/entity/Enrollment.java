package com.casestudy3.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String semester;
    private String grade;

    @ManyToOne(cascade = CascadeType.ALL)
    private Course course;

    public Enrollment() {}

    public Enrollment(String semester, String grade) {
        this.semester = semester;
        this.grade = grade;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getSemester() { return semester; }
    public void setSemester(String semester) { this.semester = semester; }
    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }
    public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }
}

