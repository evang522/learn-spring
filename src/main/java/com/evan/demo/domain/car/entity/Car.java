package com.evan.demo.domain.car.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name="car")
public class Car
{
    @Id
    private final UUID id;
    @Column(name="model")
    private final String model;
    @Column(name="make")
    private final String make;
    @Column(name="miles_travelled")
    private int milesTravelled;

    public Car(String model, String make)
    {
        this.id = UUID.randomUUID();
        this.model = model;
        this.make = make;
        this.milesTravelled = 0;
    }

    @JsonSerialize()
    public UUID id()
    {
        return this.id;
    }

    @JsonSerialize()
    public String model()
    {
        return this.model;
    }

    @JsonSerialize()
    public String make()
    {
        return this.make;
    }

    @JsonSerialize()
    public int milesTravelled()
    {
        return this.milesTravelled;
    }

    public void addMilesTravelled(int milesTravelled)
    {
        this.milesTravelled += milesTravelled;
    }

    @Override
    public String toString()
    {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", make='" + make + '\'' +
                ", milesTravelled=" + milesTravelled +
                '}';
    }
}
