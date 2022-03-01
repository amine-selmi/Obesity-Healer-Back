package com.bezkoder.spring.jwt.mongodb.security.services;

import com.bezkoder.spring.jwt.mongodb.models.ProgramPatient;
import com.bezkoder.spring.jwt.mongodb.models.Question;

import java.util.List;
import java.util.Optional;

public interface ProgramPatientService {

    Optional<ProgramPatient> getProgramPatientById (String id);
    List<ProgramPatient> getProgramPatientByUsernamePatient (String username);
    List<ProgramPatient> getProgramPatientByUsernameMedecin (String username);
    void deleteProgById(String id);


}
