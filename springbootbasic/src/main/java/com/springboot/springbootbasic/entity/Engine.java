package com.springboot.springbootbasic.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class Engine {
    private String fuelType;
    private double cc;

    // Getters and Setters
    public String getFuelType() { return fuelType; }
    public void setFuelType(String fuelType) { this.fuelType = fuelType; }
    public double getCc() { return cc; }
    public void setCc(double cc) { this.cc = cc; }

    @Override
    public String toString() {
        return "Engine{fuelType='" + fuelType + "', cc=" + cc + "}";
    }
}