package com.isa.customerservice.bookingTimeSlotsService.dtos;


import com.isa.customerservice.customerAccountService.models.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.couchbase.core.mapping.Field;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookedTimeSlotDetails {

    private String key;

    private String status;

    private String userEmailAddress;

    private String acceptedStatus;

    private String timeSlotAllocatedDate;

    private String timeSlotAllocatedTime;

    private String timeSlotAllocatedDuration;

    private String timeSlotAllocatedService;

    private int numberOfVehiclesMaxAllowedForService;

    private int availableBookingCountForService;

    private Double timeSlotAllocatedServiceDiscount;

    private List<Vehicle> timeSlotAllocatedVehicles;

}
