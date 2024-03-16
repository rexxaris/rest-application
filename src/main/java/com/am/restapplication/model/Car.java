package com.am.restapplication.model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Car extends Vehicle {

    public Car(String brand, float maxVelocity) {
        super(brand, maxVelocity);
    }

    @Override
    public void start() {
        log.info("starting engine of {}...", this.getBrand());
    }

    @Override
    public void stop() {
        log.info("stopping engine of {}...", this.getBrand());
    }
}
