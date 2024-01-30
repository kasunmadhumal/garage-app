package com.isa.userAuthenticationservice.authService.user;

import org.springframework.data.couchbase.repository.Collection;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.data.couchbase.repository.Scope;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.isa.userAuthenticationservice.authService.db_config.CollectionNames.USER_COLLECTION;
import static com.isa.userAuthenticationservice.authService.db_config.ScopeNames.DEFAULT_SCOPE;


@Collection(USER_COLLECTION)
@Repository
public interface UserRepository extends CouchbaseRepository<User, String> {
    Optional<User> findByEmail(String email);
}
