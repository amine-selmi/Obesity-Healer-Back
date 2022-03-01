package com.bezkoder.spring.jwt.mongodb.repository;

import com.bezkoder.spring.jwt.mongodb.models.FichePatient;
import com.bezkoder.spring.jwt.mongodb.models.RendezVous;
import com.bezkoder.spring.jwt.mongodb.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface RdvRepository extends MongoRepository<RendezVous,String> {

    Optional<RendezVous> findByUsernamePatient (String username);
    Optional<RendezVous> findByUsernameChirurgien (String username);
    Optional<RendezVous> findByUsernameMedecin (String username);
    List<RendezVous> findAllByUsernamePatient (String username);
    List<RendezVous> findAllByUsernameChirurgien (String username);
    List<RendezVous> findAllByUsernameMedecin (String username);

}
