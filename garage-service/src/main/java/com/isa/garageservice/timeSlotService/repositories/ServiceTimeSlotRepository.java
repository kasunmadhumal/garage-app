package com.isa.garageservice.timeSlotService.repositories;

import com.isa.garageservice.timeSlotService.models.ServiceTimeSlot;
import org.springframework.data.couchbase.repository.Collection;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import static com.isa.garageservice.dbConfig.CollectionNames.SERVICE_TIME_SLOT_COLLECTION;

@Repository
@Collection(SERVICE_TIME_SLOT_COLLECTION)
public interface ServiceTimeSlotRepository extends CouchbaseRepository<ServiceTimeSlot, String>,
        PagingAndSortingRepository<ServiceTimeSlot, String> {

}
