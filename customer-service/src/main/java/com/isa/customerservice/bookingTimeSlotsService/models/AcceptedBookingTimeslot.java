package com.isa.customerservice.bookingTimeSlotsService.models;

import com.isa.customerservice.customerAccountService.models.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;
import org.springframework.data.annotation.*;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;
import org.springframework.data.couchbase.repository.Collection;

import java.util.Date;
import java.util.List;

import static com.isa.customerservice.dbConfig.CollectionNames.ACCEPTED_BOOKING_COLLECTION;
import static com.isa.customerservice.dbConfig.CollectionNames.BOOKED_SERVICE_TIME_SLOT_COLLECTION;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Collection(ACCEPTED_BOOKING_COLLECTION)
@Document
public class AcceptedBookingTimeslot {

    @Id
    private String id;
    @Field
    private String key;

    @Field
    private String status;

    @Field
    private String acceptedStatus;

    @Field
    private String userEmailAddress;

    @Field
    private String timeSlotAllocatedDate;

    @Field
    private String timeSlotAllocatedTime;

    @Field
    private String timeSlotAllocatedDuration;

    @Field
    private String timeSlotAllocatedService;

    @Field
    private int numberOfVehiclesMaxAllowedForService;

    @Field
    private int availableBookingCountForService;

    @Field
    private Double timeSlotAllocatedServiceDiscount;

    @Field
    private List<Vehicle> timeSlotAllocatedVehicles;

    @LastModifiedBy
    private String lastModifiedBy;

    @LastModifiedDate
    private Date lastModification;

    @CreatedDate
    private Date creationDate;

    @Version
    private long version;
}
