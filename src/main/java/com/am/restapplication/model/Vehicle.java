package com.am.restapplication.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class Vehicle {

    protected String brand;
    protected float maxVelocity;

    protected abstract void start();
    protected abstract void stop();
}
