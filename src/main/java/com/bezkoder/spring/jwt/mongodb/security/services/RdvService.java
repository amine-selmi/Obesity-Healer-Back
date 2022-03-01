package com.bezkoder.spring.jwt.mongodb.security.services;

import com.bezkoder.spring.jwt.mongodb.models.FichePatient;
import com.bezkoder.spring.jwt.mongodb.models.RendezVous;
import com.bezkoder.spring.jwt.mongodb.models.User;

import java.util.List;
import java.util.Optional;

public interface RdvService {

    /*delete fiche patient by id fiche*/
    void deleteRdvById(String id);

    /*get rdv by id rdv*/
    Optional<RendezVous> getRdvById (String id);

    /*get rdv by username patient*/
    List<RendezVous> getRdvByUsernamePatient (String username);

    /*get rdv by username chirurgien*/
    List<RendezVous> getRdvByUsernameChirurgien (String username);

    /*get rdv by username Medecin*/
    List<RendezVous> getRdvByUsernameMedecin(String username);
}
