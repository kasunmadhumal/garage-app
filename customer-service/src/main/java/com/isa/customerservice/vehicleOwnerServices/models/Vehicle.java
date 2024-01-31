package com.isa.customerservice.vehicleOwnerServices.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Vehicle {

    private String model;
    private String vehicleNumber;
    private String year;
    private String fuelType;
    private String vehicleType;
    private String numberOfSeats;
    private String numberOfDoors;
    private Double distanceLimit;
}
