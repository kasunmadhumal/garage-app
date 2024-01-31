package com.isa.customerservice.vehicleOwnerServices.controllers;

import com.isa.customerservice.vehicleOwnerServices.dtos.OwnerAccountDto;
import com.isa.customerservice.vehicleOwnerServices.models.OwnerAccount;
import com.isa.customerservice.vehicleOwnerServices.services.OwnerAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/owner-account")
public class OwnerAccountController {

    private final OwnerAccountService ownerAccountService;

    public OwnerAccountController(OwnerAccountService ownerAccountService){
        this.ownerAccountService = ownerAccountService;
    }
    @GetMapping("/profile/{email}")
    public ResponseEntity<Optional<OwnerAccount>> profileDetails(@PathVariable("email") String email){
        return ResponseEntity.ok(ownerAccountService.getProfileDetails(email));
    }

    @PostMapping("/profile/create")
    public ResponseEntity<String> createProfile(@RequestBody OwnerAccountDto ownerAccountDto){
        return ResponseEntity.ok(ownerAccountService.createCustomerProfile(ownerAccountDto));
    }

    @PutMapping("profile/update")
    public ResponseEntity<String> updateProfile(@RequestBody OwnerAccountDto ownerAccountDto){
        return ResponseEntity.ok(ownerAccountService.updateCustomerProfile(ownerAccountDto));
    }

}
