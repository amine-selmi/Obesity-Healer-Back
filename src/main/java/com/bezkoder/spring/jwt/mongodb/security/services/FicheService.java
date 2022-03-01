package com.bezkoder.spring.jwt.mongodb.security.services;

import com.bezkoder.spring.jwt.mongodb.models.FichePatient;
import com.bezkoder.spring.jwt.mongodb.models.Question;

import java.util.Optional;

public interface FicheService {

    /*delete fiche patient by id fiche*/
    void deleteFicheByIdFiche(String id);

    /*get fiche patient by id fiche*/
    Optional<FichePatient> getFicheById (String id);

    /*get fiche patient by username patient*/
    Optional<FichePatient> getFicheByUsernamePatient (String username);

    /*get fiche patient by username chirurgien*/
    Optional<FichePatient> getFicheByUsernameChirurgien (String username);

    /*get fiche patient by username Medecin*/
    Optional<FichePatient> getFicheByUsernameMedecin(String username);

    /*get fiche patient by id fiche*/
    Optional<FichePatient> getQuestionById (String id);
}
