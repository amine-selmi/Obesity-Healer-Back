package com.bezkoder.spring.jwt.mongodb.controllers;

import com.bezkoder.spring.jwt.mongodb.models.ProgramPatient;
import com.bezkoder.spring.jwt.mongodb.models.RendezVous;
import com.bezkoder.spring.jwt.mongodb.payload.request.ProgramPatientRequest;
import com.bezkoder.spring.jwt.mongodb.payload.request.RdvRequest;
import com.bezkoder.spring.jwt.mongodb.payload.response.MessageResponse;
import com.bezkoder.spring.jwt.mongodb.repository.ProgramPatientRepository;
import com.bezkoder.spring.jwt.mongodb.security.services.ProgramPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/program")
public class ProgPatientController {

    @Autowired
    ProgramPatientService programPatientService;

    @Autowired
    ProgramPatientRepository programPatientRepository;

    @PostMapping("/ajout")
    public ResponseEntity add (@RequestBody ProgramPatientRequest programPatientRequest){
        ProgramPatient programPatient = new ProgramPatient();
        LocalDate dateDebut = LocalDate.parse(programPatientRequest.getDateDebut(), DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        LocalDate dateFin = LocalDate.parse(programPatientRequest.getDateFin(), DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        programPatient.setDateDebut(dateDebut);
        programPatient.setDateFin(dateFin);
        programPatient.setType(programPatientRequest.getType());
        programPatient.setDescription(programPatientRequest.getDescription());
        programPatient.setUsernamePatient(programPatientRequest.getUsernamePatient());
        programPatient.setUsernameMedecin(programPatientRequest.getUsernameMedecin());
        programPatientRepository.save(programPatient);
        return ResponseEntity.ok(new MessageResponse("program du : " + programPatient.getUsernamePatient() + " added successfully!"));

    }

    @GetMapping("/{id}")
    //@PreAuthorize("hasRole('CHIRURGIEN')")
    public ResponseEntity<ProgramPatient> getRdvById(@PathVariable String id) {
        Optional<ProgramPatient> programPatient = programPatientService.getProgramPatientById(id);
        if (programPatient.isPresent()) {
            return new ResponseEntity<>(programPatient.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

    @GetMapping("/prog/patient/{username}")
    //@PreAuthorize("hasRole('CHIRURGIEN')")
    public List<ProgramPatient> getProgByUsernamePatient(@PathVariable String username) {
        List<ProgramPatient> rdvPatient = programPatientService.getProgramPatientByUsernamePatient(username);
        return rdvPatient;

    }

    @GetMapping("/prog/medecin/{username}")
    //@PreAuthorize("hasRole('CHIRURGIEN')")
    public List<ProgramPatient> getProgByUsernameMedecin(@PathVariable String username) {
        List<ProgramPatient> rdvPatient = programPatientService.getProgramPatientByUsernameMedecin(username);
        return rdvPatient;

    }

    @DeleteMapping("/supprimer/{id}")
    public void DeleteRdv(@PathVariable String id) {
        programPatientService.deleteProgById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProgramPatient> UpdateRdv(@PathVariable String id, @RequestBody ProgramPatientRequest programPatientRequest) {

        Optional<ProgramPatient> progToUpdate = programPatientService.getProgramPatientById(id);
        if (progToUpdate.isPresent()) {
            ProgramPatient _prog = progToUpdate.get();
            LocalDate dd, df;
            dd = LocalDate.parse(programPatientRequest.getDateDebut(), DateTimeFormatter.ofPattern("yyyy/MM/dd"));
            df = LocalDate.parse(programPatientRequest.getDateFin(), DateTimeFormatter.ofPattern("yyyy/MM/dd"));
            // bd = LocalDate.parse(rendezVous.getDateRdv(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            _prog.setDescription(programPatientRequest.getDescription());
            _prog.setDateDebut(dd);
            _prog.setDateFin(df);
            _prog.setType(programPatientRequest.getType());
            return new ResponseEntity<>(programPatientRepository.save(_prog), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
