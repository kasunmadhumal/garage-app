package com.isa.customerservice.bookingTimeSlotsService.services;

import com.couchbase.client.core.deps.com.fasterxml.jackson.databind.ObjectMapper;
import com.isa.customerservice.bookingTimeSlotsService.dtos.AcceptedBookings;
import com.isa.customerservice.bookingTimeSlotsService.dtos.AvailableTimeSlot;
import com.isa.customerservice.bookingTimeSlotsService.dtos.BookedTimeSlotDetails;
import com.isa.customerservice.kafkaConfig.constant.TopicsNames;
import lombok.Getter;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



@Getter
@Service
public class KafkaCommunicationService {


    private final List<AvailableTimeSlot> availableTimeSlots = new ArrayList<>();

    private final List<AcceptedBookings> acceptedBookings = new ArrayList<>();

    private final KafkaTemplate<String, BookedTimeSlotDetails> kafkaTemplateForBookedTimeSlot;





    public KafkaCommunicationService(KafkaTemplate<String, BookedTimeSlotDetails> kafkaTemplateForBookedTimeSlot) {
        this.kafkaTemplateForBookedTimeSlot = kafkaTemplateForBookedTimeSlot;
    }

        @KafkaListener(topics = "available-time-slots", groupId = "user-group")
        public void availableTimeSlots(List<AvailableTimeSlot> availableTimeSlot){
            try {
                if (!availableTimeSlot.isEmpty()) {
                    String object = availableTimeSlot.toString();
                    String json = object.substring(1, object.length() - 1);
                    ObjectMapper objectMapper = new ObjectMapper();
                    AvailableTimeSlot resultObject = objectMapper.readValue(json, AvailableTimeSlot.class);
                    availableTimeSlots.add(resultObject);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    @KafkaListener(topics = TopicsNames.ACCEPTED_BOOKING, groupId = "user-group")
    public void acceptedTimeSlots(List<AcceptedBookings> acceptedBookings){
        try {
            if (!acceptedBookings.isEmpty()) {
                System.out.println(acceptedBookings.toString());
                String object = acceptedBookings.toString();
                String json = object.substring(1, object.length() - 1);
                ObjectMapper objectMapper = new ObjectMapper();
                AcceptedBookings resultObject = objectMapper.readValue(json, AcceptedBookings.class);
                this.acceptedBookings.add(resultObject);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void sendBookedTimeSlot(BookedTimeSlotDetails bookedTimeSlotDetails) {
        kafkaTemplateForBookedTimeSlot.send(TopicsNames.BOOKED_TIME_SLOTS, bookedTimeSlotDetails);
    }





}
