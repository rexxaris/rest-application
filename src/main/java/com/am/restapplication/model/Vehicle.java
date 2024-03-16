package com.am.restapplication.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Vehicle {

    protected String brand;
    protected float maxVelocity;

    protected abstract void start();
    protected abstract void stop();

    public Vehicle(String brand, float maxVelocity) {
        this.brand = brand;
        this.maxVelocity = maxVelocity;
    }
}
