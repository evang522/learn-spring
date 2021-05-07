package com.evan.demo.infrastructure.domain.car.repository;

import com.evan.demo.domain.car.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class CarRepository
{
    private final List<Car> cars;

    public CarRepository(
    )
    {
        this.cars = new ArrayList<Car>();
    }

    public void addCar(Car car)
    {
        this.cars.add(car);
    }

    public Optional<Car> getCarById(UUID id)
    {
        return this.cars.stream()
                .filter(car -> car.id().equals(id))
                .findFirst();
    }

    public List<Car> getCars()
    {
        return cars;
    }

    public void saveARandomCar()
    {
        Car car = new Car("Ford", "Explorer");
    }
}
