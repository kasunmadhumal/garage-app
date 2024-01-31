package com.isa.customerservice.vehicleOwnerServices.services;

import com.isa.customerservice.vehicleOwnerServices.dtos.OwnerAccountDto;
import com.isa.customerservice.vehicleOwnerServices.models.OwnerAccount;
import com.isa.customerservice.vehicleOwnerServices.repositories.IOwnerAccountRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class OwnerAccountService {

    private IOwnerAccountRepository ownerAccountRepository;

    public OwnerAccountService(IOwnerAccountRepository ownerAccountRepository){
        this.ownerAccountRepository = ownerAccountRepository;
    }
    public Optional<OwnerAccount> getProfileDetails(String email){
        return ownerAccountRepository.findByEmail(email);
    }

    public String createCustomerProfile(OwnerAccountDto ownerAccountDto){
        OwnerAccount ownerAccount = OwnerAccount.builder()
                .id(UUID.randomUUID().toString())
                .firstName(ownerAccountDto.getFirstName())
                .lastName(ownerAccountDto.getLastName())
                .email(ownerAccountDto.getEmail())
                .ownerVehicles(ownerAccountDto.getOwnerVehicles())
                .build();
        ownerAccountRepository.save(ownerAccount);
        return "successfully created";
    }

    public String updateCustomerProfile(OwnerAccountDto ownerAccountDto){

        Optional<OwnerAccount> ownerAccountExist = ownerAccountRepository.findByEmail(ownerAccountDto.getEmail());

        if (ownerAccountExist.isPresent()) {

            ownerAccountExist.get().setFirstName(ownerAccountDto.getFirstName());
            ownerAccountExist.get().setLastName(ownerAccountDto.getLastName());
            ownerAccountExist.get().setEmail(ownerAccountDto.getEmail());
            ownerAccountExist.get().setOwnerVehicles(ownerAccountDto.getOwnerVehicles());

            ownerAccountRepository.save(ownerAccountExist.get());
        }

        return "successfully updated";
    }
}
