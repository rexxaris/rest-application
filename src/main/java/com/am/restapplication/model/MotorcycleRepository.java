package com.am.restapplication.model;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MotorcycleRepository extends MongoRepository<Motorcycle, Long> {
}
