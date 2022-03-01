package com.bezkoder.spring.jwt.mongodb.controllers;


import com.bezkoder.spring.jwt.mongodb.models.FichePatient;
import com.bezkoder.spring.jwt.mongodb.models.Question;
import com.bezkoder.spring.jwt.mongodb.payload.request.QuestionRequest;
import com.bezkoder.spring.jwt.mongodb.payload.response.MessageResponse;
import com.bezkoder.spring.jwt.mongodb.repository.FicheRepository;
import com.bezkoder.spring.jwt.mongodb.repository.QuestionRepository;
import com.bezkoder.spring.jwt.mongodb.security.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    QuestionService questionService;

    @Resource
    AuthController authController;

    @Autowired
    FicheController ficheController;


    @Autowired
    FicheRepository ficheRepository;



    @PostMapping("/proposer")
    public ResponseEntity ask (@RequestBody QuestionRequest questionRequest){
        Question question = new Question();
        List<Question> questionList = new ArrayList<>();
        question.setTitre(questionRequest.getTitre());
        question.setStatut("En attente");
        question.setQuestionneur(authController.currentUserUsername);
        question.setUsernamePatient(questionRequest.getUsernamePatient());
        question.setDateQuestion(LocalDateTime.now());


        FichePatient fichePatient = ficheRepository.findByUsernamePatient(questionRequest.getUsernamePatient()).get();
//        if(fichePatient.getQuestions() != null && fichePatient.getQuestions().size() != 0) {
//            questionList = fichePatient.getQuestions();
//        }
//        questionList.add(res);
//        fichePatient.setQuestions(questionList);
        question.setIdFiche(fichePatient.getId());
        Question res = questionRepository.save(question);
//        ficheRepository.save(fichePatient);

        //System.out.println(" questionneur : " + question.getQuestionneur());
        return ResponseEntity.ok(new MessageResponse("question: "+ question.getTitre() + " added successfully!"));

    }

    @GetMapping("/{id}")
    public ResponseEntity<Question> openQuestionPatient (@PathVariable String id , @RequestBody QuestionRequest questionRequest){

        Optional<Question> qst = questionService.getQuestionById(id);
        //FichePatient fichePatient =


        if (qst.isPresent()) {
            //qst.get().setStatut("Vu");
           // ficheController.getQuestionById() = qst.get();
            return new ResponseEntity<>(questionRepository.save(qst.get()),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Question> RepondreQuestion(@PathVariable String id, @RequestBody QuestionRequest questionRequest){

        Optional<Question> qst = questionService.getQuestionById(id);
        if (qst.isPresent()){
            Question _question = qst.get();
            _question.setReponse(questionRequest.getReponse());
            _question.setDateReponse(LocalDateTime.now());
            return new ResponseEntity<>(questionRepository.save(_question), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/patient/{username}")
    public List<Question> getListeQuestionPatient (@PathVariable String username){
        List<Question> qst = questionService.getQuestionByUsernamePatient(username);
        return qst;
    }
    @GetMapping("/questionneur/{username}")
    public List<Question> getListeQuestionQuestionneur (@PathVariable String username){
        List<Question> qst = questionService.getQuestionByUsernameQuestionneur(username);
        return qst;
    }
    @GetMapping("/questions/{idf}")
    public List<Question> getListeQuestionbyIdFiche (@PathVariable String idf){
        List<Question> qst = questionService.getQuestionByIdFichePatient(idf);
        return qst;
    }
}
