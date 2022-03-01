package com.bezkoder.spring.jwt.mongodb.security.services.impl;

import com.bezkoder.spring.jwt.mongodb.models.Question;
import com.bezkoder.spring.jwt.mongodb.models.RendezVous;
import com.bezkoder.spring.jwt.mongodb.repository.QuestionRepository;
import com.bezkoder.spring.jwt.mongodb.security.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    QuestionRepository questionRepository;

    @Override
    public Optional<Question> getQuestionById(String id) {
        Optional<Question> question ;
        question = questionRepository.findById(id);
        question.get().setStatut("Vu");
        //question.get().setDateVu(LocalDateTime.now());
        return question;
    }

    @Override
    public List<Question> getQuestionByUsernamePatient(String username) {
        List<Question> question = questionRepository.findAllByUsernamePatient(username);
        return question;
    }

    @Override
    public List<Question> getQuestionByUsernameQuestionneur(String username) {
        List<Question> question = questionRepository.findAllByQuestionneur(username);
        return question;
    }

    @Override
    public List<Question> getQuestionByIdFichePatient(String idf) {
        List<Question> question = questionRepository.findAllByIdFiche(idf);
        return question;
    }
}
