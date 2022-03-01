package com.bezkoder.spring.jwt.mongodb.security.services.impl;

import com.bezkoder.spring.jwt.mongodb.models.FichePatient;
import com.bezkoder.spring.jwt.mongodb.models.RendezVous;
import com.bezkoder.spring.jwt.mongodb.repository.FicheRepository;
import com.bezkoder.spring.jwt.mongodb.repository.RdvRepository;
import com.bezkoder.spring.jwt.mongodb.security.services.RdvService;
import com.bezkoder.spring.jwt.mongodb.security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RdvServiceImpl implements RdvService {

    @Autowired
    RdvRepository rdvRepository;

    @Autowired
    UserService userService;
    @Override
    public void deleteRdvById(String id) {rdvRepository.deleteById(id);}

    @Override
    public Optional<RendezVous> getRdvById(String id) {
        Optional<RendezVous> rendezVous ;
        rendezVous = rdvRepository.findById(id);
        return rendezVous;
    }

    @Override
    public List<RendezVous> getRdvByUsernamePatient(String username) {
        List<RendezVous> rdvPatient = rdvRepository.findAllByUsernamePatient(username);
        return rdvPatient;
    }

    @Override
    public List<RendezVous> getRdvByUsernameChirurgien(String username) {
        List<RendezVous> rdvChirurgien = rdvRepository.findAllByUsernameChirurgien(username);
        return rdvChirurgien;
    }

    @Override
    public List<RendezVous> getRdvByUsernameMedecin(String username) {
        List<RendezVous> rdvMedecin = rdvRepository.findAllByUsernameMedecin(username);
        return rdvMedecin;
    }

}
