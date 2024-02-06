package com.isa.customerservice.bookingTimeSlotsService.dtos;

import com.isa.customerservice.customerAccountService.models.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AcceptedBookings {

    private String key;

    private String status;

    private String acceptedStatus;

    private String userEmailAddress;

    private String timeSlotAllocatedDate;

    private String timeSlotAllocatedTime;

    private String timeSlotAllocatedDuration;

    private String timeSlotAllocatedService;

    private int numberOfVehiclesMaxAllowedForService;

    private int availableBookingCountForService;

    private Double timeSlotAllocatedServiceDiscount;

    private List<Vehicle> timeSlotAllocatedVehicles;
}
