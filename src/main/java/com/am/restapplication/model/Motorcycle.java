package com.am.restapplication.model;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Slf4j
@Document
public class Motorcycle extends Vehicle {

    @Id
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
