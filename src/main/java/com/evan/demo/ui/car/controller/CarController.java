package com.evan.demo.ui.car.controller;

import com.evan.demo.domain.car.entity.Car;
import com.evan.demo.infrastructure.domain.car.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class CarController
{
    private final CarRepository carRepo;

    @Autowired
    public CarController(CarRepository carRepo)
    {
        this.carRepo = carRepo;
    }

    @PostMapping(path = "/api/car")
    public void addCar(@RequestBody Car car)
    {
        this.carRepo.addCar(car);
    }

    @GetMapping(path = "/api/car")
    public List<Car> getCars()
    {
        return this.carRepo.getCars();
    }

    @PostMapping(path = "/api/car/{id}/add_miles_travelled")
    public void addMilesTravelledToCar(
            @PathVariable("id") UUID id,
            @RequestBody() int miles
    )
    {
        Optional<Car> currentCar = this.carRepo.getCarById(id);

        if (currentCar.isEmpty())
        {
            return;
        }

        currentCar.get().addMilesTravelled(miles);
    }

    @GetMapping("/api/car/{id}")
    public Car getCarById(@PathVariable("id") UUID id)
    {
        return this.carRepo.getCarById(id).orElse(null);
    }
}
