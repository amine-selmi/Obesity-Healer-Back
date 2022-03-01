package com.bezkoder.spring.jwt.mongodb.security.services;

import com.bezkoder.spring.jwt.mongodb.models.Question;

import java.util.List;
import java.util.Optional;

public interface QuestionService {

    /*get question by id qst*/
    Optional<Question> getQuestionById (String id);

    /*get question by username patient*/
    List<Question> getQuestionByUsernamePatient (String username);

    /*get question by username patient*/
    List<Question> getQuestionByUsernameQuestionneur (String username);
    List<Question> getQuestionByIdFichePatient (String idf);


}
