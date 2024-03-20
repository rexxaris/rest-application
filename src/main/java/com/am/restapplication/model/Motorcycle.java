package com.am.restapplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Setter
@Getter
@Slf4j
@Entity(name = "motorcycle")
public class Motorcycle extends Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String licensePlate;

    public Motorcycle() {
        // should not be used - only for JPA
        super();
    }

    public Motorcycle(Long id, String licensePlate, String brand, float maxVelocity) {
        super(brand, maxVelocity);
        this.id = id;
        this.licensePlate = licensePlate;
    }

    @Override
    protected void start() {
        log.info("starting engine of {}...", this.getBrand());
    }

    @Override
    protected void stop() {
        log.info("starting engine of {}...", this.getBrand());
    }
}
