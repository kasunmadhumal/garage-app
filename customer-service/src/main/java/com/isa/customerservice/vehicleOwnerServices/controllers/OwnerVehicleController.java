package com.isa.customerservice.vehicleOwnerServices.controllers;


import com.isa.customerservice.vehicleOwnerServices.dtos.VehicleDto;
import com.isa.customerservice.vehicleOwnerServices.services.OwnerVehicleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/owner-vehicle")
public class OwnerVehicleController {


    private final OwnerVehicleService ownerVehicleService;
    public OwnerVehicleController(OwnerVehicleService ownerVehicleService){
        this.ownerVehicleService = ownerVehicleService;
    }
    @PostMapping("/add")
    public ResponseEntity<String> addVehicle(@RequestBody VehicleDto vehicleDto){
         return ResponseEntity.ok(ownerVehicleService.addVehicle(vehicleDto));
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateVehicle(@RequestBody VehicleDto vehicleDto){
        return ResponseEntity.ok(ownerVehicleService.updateVehicle(vehicleDto));
    }

}
