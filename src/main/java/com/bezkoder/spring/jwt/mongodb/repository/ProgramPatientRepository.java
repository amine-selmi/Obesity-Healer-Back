package com.bezkoder.spring.jwt.mongodb.repository;

import com.bezkoder.spring.jwt.mongodb.models.ProgramPatient;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProgramPatientRepository extends MongoRepository<ProgramPatient,String> {

    List<ProgramPatient> findAllByUsernamePatient (String username);
    List<ProgramPatient> findAllByUsernameMedecin (String username);

}
