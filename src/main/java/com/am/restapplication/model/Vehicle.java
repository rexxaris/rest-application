package com.am.restapplication.model;

import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public abstract class Vehicle {

    protected String brand;
    protected float maxVelocity;

    protected abstract void start();
    protected abstract void stop();
}
