package com.evan.demo.repository;

import com.evan.demo.model.Car;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class CarRepository {
    private List<Car> cars;

    public CarRepository() {
        this.cars = new ArrayList<Car>();
    }

    public void addCar(Car car) {
        this.cars.add(car);
    }

    public Optional<Car> getCarById(UUID id)
    {
        return this.cars.stream()
                .filter(car -> car.id().equals(id))
                .findFirst();
    }

    public List<Car> getCars() {
        return cars;
    }
}
