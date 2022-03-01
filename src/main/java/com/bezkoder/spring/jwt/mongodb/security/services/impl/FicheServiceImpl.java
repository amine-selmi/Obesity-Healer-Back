package com.bezkoder.spring.jwt.mongodb.security.services.impl;

import com.bezkoder.spring.jwt.mongodb.models.FichePatient;
import com.bezkoder.spring.jwt.mongodb.models.Question;
import com.bezkoder.spring.jwt.mongodb.models.User;
import com.bezkoder.spring.jwt.mongodb.repository.FicheRepository;
import com.bezkoder.spring.jwt.mongodb.security.services.FicheService;
import com.bezkoder.spring.jwt.mongodb.security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FicheServiceImpl implements FicheService {

    @Autowired
    FicheRepository ficheRepository;

    @Autowired
    UserService userService;

    @Override
    public void deleteFicheByIdFiche(String id) {
        ficheRepository.deleteById(id);
    }

    @Override
    public Optional<FichePatient> getFicheById(String id) {
        Optional<FichePatient> fichePatient ;
        fichePatient = ficheRepository.findById(id);
        return fichePatient;
    }

    @Override
    public Optional<FichePatient> getFicheByUsernamePatient(String username) {
        Optional<FichePatient> fichePatient = ficheRepository.findByUsernamePatient(username);
        return fichePatient;
    }

    @Override
    public Optional<FichePatient> getFicheByUsernameChirurgien(String username) {
        Optional<FichePatient> fichePatient = ficheRepository.findByUsernameChirurgien(username);
        return fichePatient;
    }

    @Override
    public Optional<FichePatient> getFicheByUsernameMedecin(String username) {
        Optional<FichePatient> fichePatient = ficheRepository.findByUsernameMedecin(username);
        return fichePatient;
    }

    @Override
    public Optional<FichePatient> getQuestionById(String id) {
        FichePatient fichePatient = new FichePatient();

        return Optional.empty();
    }
}
