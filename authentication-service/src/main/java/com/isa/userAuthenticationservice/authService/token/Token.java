package com.isa.userAuthenticationservice.authService.token;

import com.isa.userAuthenticationservice.authService.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.*;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;
import org.springframework.data.couchbase.repository.Collection;
import org.springframework.data.couchbase.repository.Scope;

import java.util.Date;
import java.util.UUID;

import static com.isa.userAuthenticationservice.authService.db_config.CollectionNames.TOKEN_COLLECTION;
import static com.isa.userAuthenticationservice.authService.db_config.ScopeNames.DEFAULT_SCOPE;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Collection(TOKEN_COLLECTION)
@Document
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationStrategy.UNIQUE)
    private String id;

    @Field
    private String token;

    @Field
    private TokenType tokenType = TokenType.BEARER;

    @Field
    private boolean revoked;

    @Field
    private boolean expired;

    @Field
    private User user;

    @LastModifiedBy
    private String lastModifiedBy;

    @LastModifiedDate
    private Date lastModification;

    @CreatedDate
    private Date creationDate;

    @Version
    private long version;

    private String generateId() {
        return UUID.randomUUID().toString();
    }
}
