package com.isa.customerservice.bookingTimeSlotsService.services;

import com.isa.customerservice.bookingTimeSlotsService.dtos.AvailableTimeSlot;
import com.isa.customerservice.bookingTimeSlotsService.dtos.BookedTimeSlotDetails;
import com.isa.customerservice.bookingTimeSlotsService.models.AcceptedBookingTimeslot;
import com.isa.customerservice.bookingTimeSlotsService.models.BookedServiceTimeSlot;
import com.isa.customerservice.bookingTimeSlotsService.repositories.IAcceptedBookingTimeSlotRepository;
import com.isa.customerservice.bookingTimeSlotsService.repositories.IBookedTimeSlotRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookingTimeSlotService {

    private final IBookedTimeSlotRepository bookedTimeSlotRepository;

    private final IAcceptedBookingTimeSlotRepository acceptedBookingTimeSlotRepository;
    private final KafkaCommunicationService kafkaCommunicationService;

    public BookingTimeSlotService(IBookedTimeSlotRepository bookedTimeSlotRepository, IAcceptedBookingTimeSlotRepository acceptedBookingTimeSlotRepository, KafkaCommunicationService kafkaCommunicationService){
        this.bookedTimeSlotRepository = bookedTimeSlotRepository;
        this.acceptedBookingTimeSlotRepository = acceptedBookingTimeSlotRepository;
        this.kafkaCommunicationService = kafkaCommunicationService;
    }
    public Optional<List<BookedServiceTimeSlot>> bookedServiceTimeSlots(String userEmail){
        return Optional.ofNullable(bookedTimeSlotRepository.findByUserEmailAddress(userEmail));
    }

    public Optional<String> bookServiceTimeSlot(BookedTimeSlotDetails bookedTimeSlotDetails){

        BookedServiceTimeSlot bookedServiceTimeSlot = BookedServiceTimeSlot.builder()
                .id(UUID.randomUUID().toString())
                .key(bookedTimeSlotDetails.getKey())
                .userEmailAddress(bookedTimeSlotDetails.getUserEmailAddress())
                .status(bookedTimeSlotDetails.getStatus())
                .acceptedStatus(bookedTimeSlotDetails.getAcceptedStatus())
                .numberOfVehiclesMaxAllowedForService(bookedTimeSlotDetails.getNumberOfVehiclesMaxAllowedForService())
                .availableBookingCountForService(bookedTimeSlotDetails.getAvailableBookingCountForService())
                .timeSlotAllocatedDate(bookedTimeSlotDetails.getTimeSlotAllocatedDate())
                .timeSlotAllocatedTime(bookedTimeSlotDetails.getTimeSlotAllocatedTime())
                .timeSlotAllocatedDuration(bookedTimeSlotDetails.getTimeSlotAllocatedDuration())
                .timeSlotAllocatedService(bookedTimeSlotDetails.getTimeSlotAllocatedService())
                .timeSlotAllocatedServiceDiscount(bookedTimeSlotDetails.getTimeSlotAllocatedServiceDiscount())
                .timeSlotAllocatedVehicles(bookedTimeSlotDetails.getTimeSlotAllocatedVehicles())
                .build();

        kafkaCommunicationService.sendBookedTimeSlot(bookedTimeSlotDetails);
        bookedTimeSlotRepository.save(bookedServiceTimeSlot);
        return Optional.of("successfully booked");

    }

    public Optional<String> updateServiceTimeSlot(BookedTimeSlotDetails bookedTimeSlotDetails, String id){

        Optional<BookedServiceTimeSlot> bookedServiceTimeSlots = bookedTimeSlotRepository.findById(id);

        if (bookedServiceTimeSlots.isPresent()) {
            bookedServiceTimeSlots.get().setKey(bookedTimeSlotDetails.getKey());
            bookedServiceTimeSlots.get().setAcceptedStatus(bookedTimeSlotDetails.getAcceptedStatus());
            bookedServiceTimeSlots.get().setStatus(bookedTimeSlotDetails.getStatus());
            bookedServiceTimeSlots.get().setNumberOfVehiclesMaxAllowedForService(bookedTimeSlotDetails.getNumberOfVehiclesMaxAllowedForService());
            bookedServiceTimeSlots.get().setAvailableBookingCountForService(bookedTimeSlotDetails.getAvailableBookingCountForService());
            bookedServiceTimeSlots.get().setTimeSlotAllocatedDate(bookedTimeSlotDetails.getTimeSlotAllocatedDate());
            bookedServiceTimeSlots.get().setTimeSlotAllocatedTime(bookedTimeSlotDetails.getTimeSlotAllocatedTime());
            bookedServiceTimeSlots.get().setTimeSlotAllocatedDuration(bookedTimeSlotDetails.getTimeSlotAllocatedDuration());
            bookedServiceTimeSlots.get().setTimeSlotAllocatedService(bookedTimeSlotDetails.getTimeSlotAllocatedService());
            bookedServiceTimeSlots.get().setTimeSlotAllocatedServiceDiscount(bookedTimeSlotDetails.getTimeSlotAllocatedServiceDiscount());
            bookedServiceTimeSlots.get().setTimeSlotAllocatedVehicles(bookedTimeSlotDetails.getTimeSlotAllocatedVehicles());

            bookedTimeSlotRepository.save(bookedServiceTimeSlots.get());
        }

        return Optional.of("successfully updated");
    }


    public Optional<String> deleteServiceTimeSlot(String id){
        bookedTimeSlotRepository.deleteById(id);
        return Optional.of("successfully deleted");
    }


    public List<AvailableTimeSlot> getAvailableTimeSlots(){
        return kafkaCommunicationService.getAvailableTimeSlots();
    }

    public List<AcceptedBookingTimeslot> getAcceptedBookings(String userEmail){

        return acceptedBookingTimeSlotRepository.findByUserEmailAddress(userEmail);
    }

}
