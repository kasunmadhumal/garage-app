package com.isa.customerservice.authService.token;

import org.springframework.data.couchbase.repository.Collection;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.data.couchbase.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.isa.customerservice.dbConfig.CollectionNames.TOKEN_COLLECTION;

//@Scope(DEFAULT_SCOPE)
//@Collection(TOKEN_COLLECTION)
//public interface TokenRepository extends CouchbaseRepository<Token, String> {
//
//    @Query(value = """
//            select t from Token t inner join User u\s
//            on t.user.id = u.id\s
//            where u.id = :id and (t.expired = false or t.revoked = false)\s
//            """)
//    List<Token> findAllValidTokenByUser(Integer id);
//
//    Optional<Token> findByToken(String token);
//}

@Collection(TOKEN_COLLECTION)
@Repository
public interface TokenRepository extends CouchbaseRepository<Token, String> ,
        PagingAndSortingRepository<Token, String> {
    ;

    List<Token> findAllByExpiredIsFalseAndRevokedIsFalse(String userId);

    @Query("#{#n1ql.selectEntity} WHERE #{#n1ql.filter} AND token = $1")
    Optional<Token> findByToken(String token);


}