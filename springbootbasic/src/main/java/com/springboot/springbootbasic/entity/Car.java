package com.springboot.springbootbasic.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;
    private double price;

    @Embedded
    private Engine engine;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public Engine getEngine() { return engine; }
    public void setEngine(Engine engine) { this.engine = engine; }

    @Override
    public String toString() {
        return "Car{brand='" + brand + "', price=" + price + ", engine=" + engine + "}";
    }
}
