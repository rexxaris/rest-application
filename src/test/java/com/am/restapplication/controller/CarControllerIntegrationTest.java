package com.am.restapplication.controller;

import com.am.restapplication.RestApplication;
import com.am.restapplication.model.Car;
import com.am.restapplication.service.CarService;
import com.am.restapplication.util.CarGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static com.am.restapplication.config.Constants.ServiceMapping.*;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = RestApplication.class)
@AutoConfigureMockMvc
public class CarControllerIntegrationTest {

    @Autowired
    MockMvc mvc;

    @Autowired
    CarService carService;
    @Autowired
    CarGenerator carGenerator;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void getAllCars_thenReturnProperList() throws Exception {
        List<Car> cars = carService.getCars();
        MvcResult result = mvc.perform(get(CARS_BASE_MAPPING + CARS_GET_ALL_MAPPING))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(10)))
                .andReturn();

        String carsFromService = objectMapper.writeValueAsString(cars);
        String carsResponse = result.getResponse().getContentAsString();

        assertEquals(carsFromService, carsResponse);
    }

    @Test
    void addCar_shouldAddNewCar() throws Exception {
        Car newCarToAdd = createCarNotOnList();

        MvcResult result = mvc.perform(post(CARS_BASE_MAPPING + CARS_ADD_CAR_MAPPING)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newCarToAdd))
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", containsString(String.format("car brand: %s added to list", newCarToAdd.getBrand()))))
                .andReturn();

        String carsResponse = result.getResponse().getContentAsString();
        assertEquals(String.format("car brand: %s added to list", newCarToAdd.getBrand()), carsResponse);
    }

    Car createCarNotOnList() {
        List<Car> carList = carService.getCars();
        Car car;
        while (true) {
            car = carGenerator.generateCar();
            Car finalCar = car;
            if (carList.stream().noneMatch(carr -> carr.getBrand().equals(finalCar.getBrand()))) {
                break;
            }
        }
        return car;
    }
}
