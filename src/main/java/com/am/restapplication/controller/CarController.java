package com.am.restapplication.controller;

import com.am.restapplication.model.Car;
import com.am.restapplication.service.CarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/car")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping("/getAllCars")
    public List<Car> getAllCars() {
        return carService.getCars();
    }

    @PutMapping("/addCar")
    public String addCar(@RequestBody Car car) {
        return carService.addCar(car);
    }

    @DeleteMapping("/removeCar/{brand}")
    public String removeCar(@PathVariable String brand) {
        return carService.removeCar(brand);
    }
}
