package com.isa.garageservice.timeSlotService.controllers;


import com.isa.garageservice.timeSlotService.dao.ServiceTimeSlotDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/timeSlot")
public class TimeSlotController {


    @PostMapping("/add")
    public String addTimeSlot(@RequestBody ServiceTimeSlotDao serviceTimeSlotDao){
        return "success";
    }

}
