package com.study.tdd.car;

import org.springframework.stereotype.Service;

@Service
public class CarService {

    private CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car getCarDetails(String name) {
        return this.carRepository.findByName(name).orElseThrow(() -> new CarNotFoundException("Car was not found with this name" + name));
    }
}
