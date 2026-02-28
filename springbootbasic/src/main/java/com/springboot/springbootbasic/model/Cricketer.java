package com.springboot.springbootbasic.model;

import org.springframework.stereotype.Component;

//@Component
public class Cricketer {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBatting_average() {
        return batting_average;
    }

    public void setBatting_average(double batting_average) {
        this.batting_average = batting_average;
    }

    public int getNo_of_matches() {
        return no_of_matches;
    }

    public void setNo_of_matches(int no_of_matches) {
        this.no_of_matches = no_of_matches;
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    private String name;
    private String role;
    private int runs;
    private int no_of_matches;
    private double batting_average;

    public Cricketer() {
        this.name = "Virat Kohli";
        this.role = "Batsman";
        this.runs = 12000;
        this.no_of_matches = 250;
        this.batting_average = 58.5;
    }

    @Override
    public String toString() {
        return "Cricketer{" +
                "name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", runs=" + runs +
                ", no_of_matches=" + no_of_matches +
                ", batting_average=" + batting_average +
                '}';
    }
}
