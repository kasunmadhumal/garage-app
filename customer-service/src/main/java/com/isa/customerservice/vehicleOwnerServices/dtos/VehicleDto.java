package com.isa.customerservice.vehicleOwnerServices.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.couchbase.core.mapping.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VehicleDto {

    private String model;
    private String vehicleNumber;
    private String year;
    private String fuelType;
    private String vehicleType;
    private String numberOfSeats;
    private String numberOfDoors;
    private Double distanceLimit;
    private String ownerEmail;

}
