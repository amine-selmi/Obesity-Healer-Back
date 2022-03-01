package com.bezkoder.spring.jwt.mongodb.controllers;


import com.bezkoder.spring.jwt.mongodb.models.FichePatient;
import com.bezkoder.spring.jwt.mongodb.models.RendezVous;
import com.bezkoder.spring.jwt.mongodb.models.User;
import com.bezkoder.spring.jwt.mongodb.payload.request.FicheRequest;
import com.bezkoder.spring.jwt.mongodb.payload.request.RdvRequest;
import com.bezkoder.spring.jwt.mongodb.payload.response.MessageResponse;
import com.bezkoder.spring.jwt.mongodb.repository.RdvRepository;
import com.bezkoder.spring.jwt.mongodb.security.services.RdvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/rdv")
public class RdvController {

    @Autowired
    RdvRepository rdvRepository;

    @Autowired
    RdvService rdvService;

    @PostMapping("/ajout")
    public ResponseEntity addFiche(@RequestBody RdvRequest rdvRequest) {
        RendezVous rendezVous = new RendezVous();
        LocalDate daterdv = LocalDate.parse(rdvRequest.getDateRdv(), DateTimeFormatter.ofPattern("yyyy/MM/dd")).plusDays(1);
        rendezVous.setUsernamePatient(rdvRequest.getUsernamePatient());
        rendezVous.setUsernameChirurgien(rdvRequest.getUsernameChirurgien());
        rendezVous.setUsernameMedecin(rdvRequest.getUsernameMedecin());
        rendezVous.setCommentaire(rdvRequest.getCommentaire());
        rendezVous.setLieuxRdv(rdvRequest.getLieuxRdv());
        //rendezVous.setRdvEffectue(rdvRequest.getRdvEffectue());
        rendezVous.setRdvEffectue(false);
        rendezVous.setDateRdv(daterdv);
        rendezVous.setIdFiche(rdvRequest.getIdFiche());


        rdvRepository.save(rendezVous);
        return ResponseEntity.ok(new MessageResponse("rdv du : " + rendezVous.getUsernamePatient() + " added successfully!"));

    }

    @DeleteMapping("/supprimer/{id}")
    public void DeleteRdv(@PathVariable String id) {
        rdvService.deleteRdvById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RendezVous> UpdateRdv(@PathVariable String id, @RequestBody RdvRequest rdvRequest) {

        Optional<RendezVous> RdvToUpdate = rdvService.getRdvById(id);
        if (RdvToUpdate.isPresent()) {
            RendezVous _rdv = RdvToUpdate.get();
            LocalDate bd;
            bd = LocalDate.parse(rdvRequest.getDateRdv(), DateTimeFormatter.ofPattern("yyyy/MM/dd")).plusDays(1);
            // bd = LocalDate.parse(rendezVous.getDateRdv(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            _rdv.setCommentaire(rdvRequest.getCommentaire());
            _rdv.setLieuxRdv(rdvRequest.getLieuxRdv());
            _rdv.setDateRdv(bd);
            _rdv.setRdvEffectue(true);
            //System.out.println("bd : " + bd);
            return new ResponseEntity<>(rdvRepository.save(_rdv), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    //@PreAuthorize("hasRole('CHIRURGIEN')")
    public ResponseEntity<RendezVous> getRdvById(@PathVariable String id) {
        Optional<RendezVous> Rdv = rdvService.getRdvById(id);
        if (Rdv.isPresent()) {
            return new ResponseEntity<>(Rdv.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

    @GetMapping("/patient/{username}")
    //@PreAuthorize("hasRole('CHIRURGIEN')")
    public List<RendezVous> getRdvByUsernamePatient(@PathVariable String username) {
        List<RendezVous> rdvPatient = rdvService.getRdvByUsernamePatient(username);
        return rdvPatient;

    }

    @GetMapping("/chirurgien/{username}")
    //@PreAuthorize("hasRole('CHIRURGIEN')")
    public List<RendezVous> getRdvByUsernameChirurgien(@PathVariable String username) {
        List<RendezVous> rdvChirurgien = rdvService.getRdvByUsernameChirurgien(username);
        return rdvChirurgien;

    }


    @GetMapping("/medecin/{username}")
    //@PreAuthorize("hasRole('CHIRURGIEN')")
    public List<RendezVous> getRdvByUsernameMedecin(@PathVariable String username) {
        List<RendezVous> rdvMedecin = rdvService.getRdvByUsernameMedecin(username);
        return rdvMedecin;
    }
}
