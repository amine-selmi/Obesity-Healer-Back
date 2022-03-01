package com.bezkoder.spring.jwt.mongodb.security.services.impl;

import com.bezkoder.spring.jwt.mongodb.models.ProgramPatient;
import com.bezkoder.spring.jwt.mongodb.repository.ProgramPatientRepository;
import com.bezkoder.spring.jwt.mongodb.security.services.ProgramPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProgramPatientServiceImpl implements ProgramPatientService {

    @Autowired
    ProgramPatientRepository programPatientRepository;

    @Override
    public Optional<ProgramPatient> getProgramPatientById(String id) {
        Optional<ProgramPatient> prog = programPatientRepository.findById(id);
        return prog;
    }

    @Override
    public List<ProgramPatient> getProgramPatientByUsernamePatient(String username) {
       return programPatientRepository.findAllByUsernamePatient(username);
    }

    @Override
    public List<ProgramPatient> getProgramPatientByUsernameMedecin(String username) {
        return programPatientRepository.findAllByUsernameMedecin(username);
    }

    @Override
    public void deleteProgById(String id) {
        programPatientRepository.deleteById(id);
    }

//    @Override
//    public Optional<ProgramPatient> getProgramById(String id) {
//        Optional<ProgramPatient> prog = programPatientRepository.findById(id);
//        return prog;
//    }
}
