package com.isa.customerservice.vehicleOwnerServices.services;

import com.isa.customerservice.vehicleOwnerServices.dtos.VehicleDto;
import com.isa.customerservice.vehicleOwnerServices.models.OwnerAccount;
import com.isa.customerservice.vehicleOwnerServices.models.Vehicle;
import com.isa.customerservice.vehicleOwnerServices.repositories.IOwnerAccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class OwnerVehicleService {

    private final IOwnerAccountRepository ownerAccountRepository;
    public OwnerVehicleService(IOwnerAccountRepository ownerAccountRepository){
        this.ownerAccountRepository = ownerAccountRepository;
    }

    public String addVehicle(VehicleDto vehicleDto){
        Optional<OwnerAccount> existOwnerAccount = ownerAccountRepository.findByEmail(vehicleDto.getOwnerEmail());

        Vehicle newVehicle = Vehicle.builder()
                .model(vehicleDto.getModel())
                .vehicleNumber(vehicleDto.getVehicleNumber())
                .year(vehicleDto.getYear())
                .fuelType(vehicleDto.getFuelType())
                .vehicleType(vehicleDto.getVehicleType())
                .numberOfSeats(vehicleDto.getNumberOfSeats())
                .numberOfDoors(vehicleDto.getNumberOfDoors())
                .distanceLimit(vehicleDto.getDistanceLimit())
                .build();

        if(existOwnerAccount.isPresent()){
            List<Vehicle> existsVehicles = existOwnerAccount.get().getOwnerVehicles();
            existsVehicles.add(newVehicle);
            existOwnerAccount.get().setOwnerVehicles(existsVehicles);
            ownerAccountRepository.save(existOwnerAccount.get());
        }
        return "successfully saved";
    }

    public String updateVehicle(VehicleDto vehicleDto){
        Optional<OwnerAccount> existOwnerAccount = ownerAccountRepository.findByEmail(vehicleDto.getOwnerEmail());
        if(existOwnerAccount.isPresent()){
            List<Vehicle> existVehicles = existOwnerAccount.get().getOwnerVehicles();
            for(Vehicle vehicle: existVehicles){
                if(Objects.equals(vehicle.getVehicleNumber(), vehicleDto.getVehicleNumber())){
                    existVehicles.remove(vehicle);
                    vehicle.setModel(vehicleDto.getModel());
                    vehicle.setVehicleNumber(vehicleDto.getVehicleNumber());
                    vehicle.setYear(vehicleDto.getYear());
                    vehicle.setFuelType(vehicle.getFuelType());
                    vehicle.setVehicleType(vehicleDto.getVehicleType());
                    vehicle.setNumberOfSeats(vehicleDto.getNumberOfSeats());
                    vehicle.setNumberOfDoors(vehicleDto.getNumberOfDoors());
                    vehicle.setDistanceLimit(vehicleDto.getDistanceLimit());
                    existVehicles.add(vehicle);
                }
            }
            existOwnerAccount.get().setOwnerVehicles(existVehicles);
            ownerAccountRepository.save(existOwnerAccount.get());
        }

        return "update successfully";
    }
}
