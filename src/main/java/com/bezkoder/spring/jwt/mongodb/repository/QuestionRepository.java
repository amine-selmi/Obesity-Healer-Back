package com.bezkoder.spring.jwt.mongodb.repository;

import com.bezkoder.spring.jwt.mongodb.models.Question;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface QuestionRepository extends MongoRepository<Question,String> {

    List<Question> findAllByUsernamePatient (String username);
    List<Question> findAllByQuestionneur(String username);
    List<Question> findAllByIdFiche(String idf);
}
