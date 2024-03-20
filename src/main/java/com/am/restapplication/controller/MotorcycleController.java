package com.am.restapplication.controller;

import com.am.restapplication.model.Motorcycle;
import com.am.restapplication.service.MotorcycleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.am.restapplication.config.Constants.ServiceMapping.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(MOTORCYCLES_BASE_MAPPING)
public class MotorcycleController {

    private final MotorcycleService motorcycleService;

    @GetMapping(MOTORCYCLES_GET_ALL_MAPPING)
    public List<Motorcycle> getAllCars() {
        return motorcycleService.getMotorcycles();
    }

    @PostMapping(MOTORCYCLES_ADD_CAR_MAPPING)
    public String addCar(@RequestBody Motorcycle motorcycle) {
        return motorcycleService.addMotorcycle(motorcycle);
    }

    @DeleteMapping(MOTORCYCLES_REMOVE_CAR_BY_BRAND_MAPPING)
    public String removeCar(@PathVariable String brand) {
        return motorcycleService.removeMotorcycle(brand);
    }
}
