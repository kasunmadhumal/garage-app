package com.isa.customerservice.vehicleOwnerServices.dtos;

import com.isa.customerservice.vehicleOwnerServices.models.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OwnerAccountDto {

    private String firstName;
    private String lastName;
    private String email;
    private List<Vehicle> ownerVehicles;

}
