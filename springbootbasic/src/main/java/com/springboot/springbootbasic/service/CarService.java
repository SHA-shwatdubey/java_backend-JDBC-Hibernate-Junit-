package com.springboot.springbootbasic.service;

import com.springboot.springbootbasic.entity.Car;
import com.springboot.springbootbasic.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public Car saveCar(Car car) {
        return carRepository.save(car);
    }
}

