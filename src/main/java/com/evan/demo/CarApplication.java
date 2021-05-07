package com.evan.demo;

import com.evan.demo.domain.car.entity.Car;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@SpringBootApplication
public class CarApplication
{
    public static void main(String[] args)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");

        EntityManager em = emf.createEntityManager();

        Car car = new Car("Ford", "bla");
        em.getTransaction().begin();
        em.persist(car);
        em.flush();
        em.getTransaction().commit();

        SpringApplication.run(CarApplication.class, args);
    }
}
