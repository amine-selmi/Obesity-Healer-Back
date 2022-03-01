package com.bezkoder.spring.jwt.mongodb.controllers;


import com.bezkoder.spring.jwt.mongodb.models.FichePatient;
import com.bezkoder.spring.jwt.mongodb.models.Personnel;
import com.bezkoder.spring.jwt.mongodb.models.Question;
import com.bezkoder.spring.jwt.mongodb.models.User;
import com.bezkoder.spring.jwt.mongodb.payload.request.FicheRequest;
import com.bezkoder.spring.jwt.mongodb.payload.response.MessageResponse;
import com.bezkoder.spring.jwt.mongodb.repository.FicheRepository;
import com.bezkoder.spring.jwt.mongodb.security.services.FicheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/fiche")
public class FicheController {

    @Autowired
    FicheRepository ficheRepository;

    @Autowired
    FicheService ficheService;

    public static Question qst ;


    @PostMapping("/ajout")
    public ResponseEntity addFiche (@RequestBody FicheRequest ficheRequest){
        FichePatient fiche = new FichePatient();
        fiche.setUsernamePatient(ficheRequest.getUsernamePatient());
        fiche.setUsernameChirurgien(ficheRequest.getUsernameChirurgien());
        fiche.setUsernameMedecin(ficheRequest.getUsernameMedecin());
        fiche.setFicheBody(ficheRequest.getFicheBody());

        ficheRepository.save(fiche);
        return ResponseEntity.ok(new MessageResponse("fiche "+fiche.getUsernamePatient()+ " added successfully!"));

    }

    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<User> DeleteFiche(@PathVariable String id) {
        try {
            ficheService.deleteFicheByIdFiche(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<FichePatient> UpdateFiche(@PathVariable String id, @RequestBody FichePatient fichePatient){

        Optional<FichePatient> ficheToUpdate = ficheService.getFicheById(id);
        if (ficheToUpdate.isPresent()){
            FichePatient _fiche = ficheToUpdate.get();
            _fiche.setFicheBody(fichePatient.getFicheBody());
            return new ResponseEntity<>(ficheRepository.save(_fiche), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    //@PreAuthorize("hasRole('CHIRURGIEN')")
    public ResponseEntity<FichePatient> getFicheById(@PathVariable String id) {
        Optional<FichePatient> fichePatient =ficheService.getFicheById(id);
        if (fichePatient.isPresent()){
            return new ResponseEntity<>(fichePatient.get() ,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    @GetMapping("/get/{username}")
    //@PreAuthorize("hasRole('CHIRURGIEN')")
    public ResponseEntity<FichePatient> getFicheByUsernamePatient(@PathVariable String username) {
        Optional<FichePatient> fichePatient =ficheService.getFicheByUsernamePatient(username);
        if (fichePatient.isPresent()){
            return new ResponseEntity<>(fichePatient.get() ,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

    @GetMapping("/getCh/{username}")
    //@PreAuthorize("hasRole('CHIRURGIEN')")
    public ResponseEntity<FichePatient> getFicheByUsernameChirurgien(@PathVariable String username) {
        Optional<FichePatient> fichePatient =ficheService.getFicheByUsernameChirurgien(username);
        if (fichePatient.isPresent()){
            return new ResponseEntity<>(fichePatient.get() ,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }


    @GetMapping("/getMedecin/{username}")
    //@PreAuthorize("hasRole('CHIRURGIEN')")
    public ResponseEntity<FichePatient> getFicheByUsernameMedecin(@PathVariable String username) {
        Optional<FichePatient> fichePatient =ficheService.getFicheByUsernameMedecin(username);
        if (fichePatient.isPresent()){
            return new ResponseEntity<>(fichePatient.get() ,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

//    @GetMapping("/{idf}/question/{idq}")
//    //@PreAuthorize("hasRole('CHIRURGIEN')")
//    public ResponseEntity<Question> getQuestionById(@PathVariable String idf,@PathVariable String idq ) {
//        Optional<FichePatient> fichePatient =ficheService.getFicheById(idf);
////        List<Question> questionList= fichePatient.get().getQuestions();
//        System.out.println("***********" + questionList.size());
////        Predicate<Question> byId = question -> question.getId().equals(id)  ;
////        questionList = questionList.stream().filter(byId).collect(Collectors.toList());
//        if (fichePatient.isPresent()){
//            for (Question q : questionList){
//            if (q.getId().equals(idq)) {
//                qst = q;
//                System.out.println("***********" + qst.getId());
//            }
//            }
//            return new ResponseEntity<>(qst ,HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//
//    }
}
