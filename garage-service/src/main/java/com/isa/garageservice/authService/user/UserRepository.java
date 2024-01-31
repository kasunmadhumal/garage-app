package com.isa.garageservice.authService.user;

import org.springframework.data.couchbase.repository.Collection;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.isa.garageservice.dbConfig.CollectionNames.USER_COLLECTION;


@Collection(USER_COLLECTION)
@Repository
public interface UserRepository extends CouchbaseRepository<User, String> {
    Optional<User> findByEmail(String email);
}
