package com.am.restapplication.controller;

import com.am.restapplication.model.Car;
import com.am.restapplication.service.CarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.am.restapplication.config.Constants.ServiceMapping.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(CARS_BASE_MAPPING)
public class CarController {

    private final CarService carService;

    @GetMapping(CARS_GET_ALL_MAPPING)
    public List<Car> getAllCars() {
        return carService.getCars();
    }

    @PostMapping(CARS_ADD_CAR_MAPPING)
    public String addCar(@RequestBody Car car) {
        return carService.addCar(car);
    }

    @DeleteMapping(CARS_REMOVE_CAR_BY_BRAND_MAPPING)
    public String removeCar(@PathVariable String brand) {
        return carService.removeCar(brand);
    }
}
