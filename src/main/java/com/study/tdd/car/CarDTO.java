package com.study.tdd.car;

public class CarDTO {

    private Long id;
    private String name;
    private String type;

    public CarDTO() {
    }

    public CarDTO(Long id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public CarDTO(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public static CarDTO of(Car car) {
        return new CarDTO(car.getId(), car.getName(), car.getType());
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
