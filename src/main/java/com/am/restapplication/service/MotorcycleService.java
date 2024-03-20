package com.am.restapplication.service;

import com.am.restapplication.model.Motorcycle;
import com.am.restapplication.model.MotorcycleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MotorcycleService {

    private final MotorcycleRepository motorcycleRepository;

    public List<Motorcycle> getMotorcycles() {
        Iterable<Motorcycle> all = motorcycleRepository.findAll();
        return (List<Motorcycle>) motorcycleRepository.findAll();
    }

    public String addMotorcycle(Motorcycle motorcycle) {
        motorcycleRepository.save(motorcycle);
        return String.format("Motorcycle %s added", motorcycle.getBrand());
    }

    public String removeMotorcycle(String brand) {
        // TODO: add remove by brand from repository
        return "";
    }
}
