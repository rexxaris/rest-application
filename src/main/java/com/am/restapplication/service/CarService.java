package com.am.restapplication.service;

import com.am.restapplication.model.Car;
import com.am.restapplication.util.CarGenerator;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class CarService {

    @Getter
    private final List<Car> cars;

    private final CarGenerator carGenerator;

    public CarService(CarGenerator carGenerator) {
        this.carGenerator = carGenerator;

        this.cars = new ArrayList<>();
        while (cars.size() < 10) {
            addCar(carGenerator.generateCar());
        }
    }

    public String addCar(Car car) {
        String brand = car.getBrand();
        log.info("adding new car brand: {}", brand);
        String responseMessage;
        if (cars.stream().anyMatch(carr -> carr.getBrand().equals(brand))) {
            responseMessage = String.format("car brand: %s already exists", brand);
        } else {
            boolean isBrandValid = carGenerator.isBrandValid(brand);
            if (isBrandValid) {
                responseMessage = String.format("car brand: %s added to list", brand);
                cars.add(car);
            } else {
                responseMessage = String.format("unknown brand: %s, insert different one", brand);
            }
        }
        log.info(responseMessage);
        return responseMessage;
    }

    public String removeCar(String brand) {
        log.info("removing car brand: {}", brand);
        boolean isRemoved = cars.removeIf(car -> car.getBrand().equals(brand));
        return String.format("car brand %s remove operation: %s", brand, isRemoved);
    }
}
