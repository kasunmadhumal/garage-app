package com.isa.garageservice.timeSlotService.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.*;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;
import org.springframework.data.couchbase.repository.Collection;

import java.util.Date;

import static com.isa.garageservice.dbConfig.CollectionNames.SERVICE_TIME_SLOT_COLLECTION;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Collection(SERVICE_TIME_SLOT_COLLECTION)
@Document
public class ServiceTimeSlot {

    @Id
    private String id;
    @Field
    private String serviceTimeSlotDate;
    @Field
    private String serviceTimeSlotStartingTime;
    @Field
    private String serviceTimeSlotEndingTime;
    @Field
    private int numberOfVehiclesCanService;
    @Field
    private String serviceTimeSlotStatus;
    @LastModifiedBy
    private String lastModifiedBy;
    @LastModifiedDate
    private Date lastModification;
    @CreatedDate
    private Date creationDate;
    @Version
    private long version;
}
