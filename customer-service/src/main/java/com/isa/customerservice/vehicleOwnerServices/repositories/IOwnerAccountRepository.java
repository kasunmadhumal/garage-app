package com.isa.customerservice.vehicleOwnerServices.repositories;

import com.isa.customerservice.vehicleOwnerServices.models.OwnerAccount;
import org.springframework.data.couchbase.repository.Collection;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.isa.customerservice.dbConfig.CollectionNames.VEHICLE_OWNER_ACCOUNT_COLLECTION;

@Repository
@Collection(VEHICLE_OWNER_ACCOUNT_COLLECTION)
public interface IOwnerAccountRepository  extends CouchbaseRepository<OwnerAccount, String>,
        PagingAndSortingRepository<OwnerAccount, String> {

    Optional<OwnerAccount> findByEmail(String email);

}
