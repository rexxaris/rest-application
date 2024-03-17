package com.am.restapplication.config;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constants {

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class ServiceMapping {
        public static final String CARS_BASE_MAPPING = "/cars";
        public static final String CARS_GET_ALL_MAPPING = "/getAllCars";
        public static final String CARS_ADD_CAR_MAPPING = "/addCar";
        public static final String CARS_REMOVE_CAR_BY_BRAND_MAPPING = "/removeCar/{brand}";
    }
}
