package com.evan.demo;

import com.evan.demo.model.Car;
import com.evan.demo.repository.CarRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication
{
    public static void main(String[] args)
    {
        Car car = new Car("Blaa", "Bla");
        CarRepository repo = new CarRepository();
        repo.addCar(car);

        SpringApplication.run(DemoApplication.class, args);
    }
}
