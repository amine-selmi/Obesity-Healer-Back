package com.bezkoder.spring.jwt.mongodb.repository;

import com.bezkoder.spring.jwt.mongodb.models.Patient;
import com.bezkoder.spring.jwt.mongodb.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PatientRepository extends MongoRepository<Patient,String> {

    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

}
