package com.isa.garageservice.timeSlotService.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.couchbase.core.mapping.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceTimeSlotDao {

    private String serviceTimeSlotDate;
    private String serviceTimeSlotStartingTime;
    private String serviceTimeSlotEndingTime;
    private int numberOfVehiclesCanService;
    private String serviceTimeSlotStatus;

}
