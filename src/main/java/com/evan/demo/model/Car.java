package com.evan.demo.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.UUID;

public class Car
{
    private final String model;
    private final String make;
    private final UUID id;
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

    public String toString()
    {
        return this.make + " : " + this.model;
    }
}
