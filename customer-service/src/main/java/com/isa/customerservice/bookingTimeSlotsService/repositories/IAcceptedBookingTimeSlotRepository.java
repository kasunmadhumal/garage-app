package com.isa.customerservice.bookingTimeSlotsService.repositories;


import com.isa.customerservice.bookingTimeSlotsService.models.AcceptedBookingTimeslot;
import com.isa.customerservice.bookingTimeSlotsService.models.BookedServiceTimeSlot;
import org.springframework.data.couchbase.repository.Collection;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.isa.customerservice.dbConfig.CollectionNames.ACCEPTED_BOOKING_COLLECTION;
import static com.isa.customerservice.dbConfig.CollectionNames.BOOKED_SERVICE_TIME_SLOT_COLLECTION;

@Collection(ACCEPTED_BOOKING_COLLECTION)
@Repository
public interface IAcceptedBookingTimeSlotRepository extends CouchbaseRepository<AcceptedBookingTimeslot, String> {

    List<AcceptedBookingTimeslot> findByUserEmailAddress(String userEmail);
}
