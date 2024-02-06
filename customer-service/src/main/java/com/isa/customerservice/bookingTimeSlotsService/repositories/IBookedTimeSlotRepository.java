package com.isa.customerservice.bookingTimeSlotsService.repositories;

import com.isa.customerservice.bookingTimeSlotsService.models.BookedServiceTimeSlot;
import org.springframework.data.couchbase.repository.Collection;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

import static com.isa.customerservice.dbConfig.CollectionNames.BOOKED_SERVICE_TIME_SLOT_COLLECTION;

@Collection(BOOKED_SERVICE_TIME_SLOT_COLLECTION)
@Repository
public interface IBookedTimeSlotRepository extends CouchbaseRepository<BookedServiceTimeSlot, String> {
}
