package com.bezkoder.spring.jwt.mongodb.repository;

import com.bezkoder.spring.jwt.mongodb.models.Chirurgien;
import com.bezkoder.spring.jwt.mongodb.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ChirurgienRepository extends MongoRepository<Chirurgien,String> {

    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
