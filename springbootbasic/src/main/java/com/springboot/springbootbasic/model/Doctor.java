package com.springboot.springbootbasic.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("request")
public class Doctor {
    private String name;
    private String specialization;

    public Doctor() {
        this.name = "Dr. Smith";
        this.specialization = "General Medicine";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
