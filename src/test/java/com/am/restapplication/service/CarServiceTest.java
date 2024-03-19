package com.am.restapplication.service;

import com.am.restapplication.model.Car;
import com.am.restapplication.util.CarGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(classes = {CarService.class, CarGenerator.class})
class CarServiceTest {

    @Autowired
    CarService carService;
    @Autowired
    CarGenerator carGenerator;

    @Test
    void addCar_shouldAddNewCar() {
        Car carNotOnList = createCarNotOnList();

        String response = carService.addCar(carNotOnList);

        assertTrue(carService.getCars().stream().anyMatch(car -> car.getBrand().equals(carNotOnList.getBrand())));
        assertEquals(11,carService.getCars().size());
        assertTrue(response.contains("added to list"));
    }

    @Test
    void addCar_addAlreadyExist() {
        Car carOnList = carService.getCars().get(0);

        String response = carService.addCar(carOnList);

        assertTrue(response.contains("already exists"));
        assertEquals(10,carService.getCars().size());
    }

    @Test
    void addCar_addUnknownBrand() {
        Car carWithUnknownBrand = new Car("unknown-brand", 0);

        String response = carService.addCar(carWithUnknownBrand);

        assertTrue(carService.getCars().stream().noneMatch(car -> car.getBrand().equals(carWithUnknownBrand.getBrand())));
        assertTrue(response.contains("unknown brand"));
        assertEquals(10,carService.getCars().size());
    }

    @Test
    void removeCar_shouldRemoveOneOfTheExistingCar() {
        Random random = new Random();
        List<Car> carList = carService.getCars();
        Car randomCar = carList.get(random.nextInt(carList.size()));

        carService.removeCar(randomCar.getBrand());

        assertTrue(carService.getCars().stream().noneMatch(car -> car.getBrand().equals(randomCar.getBrand())));
    }

    @Test
    void removeCar_failToRemoveNotExistingCar() {
        Car carWithUnknownBrand = new Car("unknown-brand", 0);

        String response = carService.removeCar(carWithUnknownBrand.getBrand());

        assertEquals(String.format("car brand %s remove operation: %s", carWithUnknownBrand.getBrand(), false), response);
    }

    @Test
    void getCars() {
        List<Car> carList = carService.getCars();
        assertEquals(10, carList.size());
    }

    Car createCarNotOnList() {
        List<Car> carList = carService.getCars();
        Car car;
        while(true) {
            car = carGenerator.generateCar();
            Car finalCar = car;
            if (carList.stream().noneMatch(carr -> carr.getBrand().equals(finalCar.getBrand()))) {
                break;
            }
        }
        return car;
    }
}
