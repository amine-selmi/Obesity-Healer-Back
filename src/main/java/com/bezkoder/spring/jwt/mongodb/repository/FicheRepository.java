package com.bezkoder.spring.jwt.mongodb.repository;

import com.bezkoder.spring.jwt.mongodb.models.FichePatient;
import com.bezkoder.spring.jwt.mongodb.models.Question;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface FicheRepository extends MongoRepository<FichePatient,String> {

    Optional<FichePatient> findByUsernamePatient (String username);

    Optional<FichePatient> findByUsernameChirurgien (String username);

    Optional<FichePatient> findByUsernameMedecin (String username);

    Optional<FichePatient> findById (String id);


}
