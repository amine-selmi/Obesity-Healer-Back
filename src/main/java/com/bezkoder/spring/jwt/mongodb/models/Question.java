package com.bezkoder.spring.jwt.mongodb.models;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("question")
public class Question {

    private String id;
    private String titre;
    private String Statut;
    private String reponse;
    private String usernamePatient;
    private String questionneur;
    private String idFiche;
    private LocalDateTime dateQuestion;
    private LocalDateTime dateReponse;
    //private LocalDateTime dateVu;


    public Question() {
    }

    public String getUsernamePatient() {
        return usernamePatient;
    }

    public void setUsernamePatient(String usernamePatient) {
        this.usernamePatient = usernamePatient;
    }

    public String getQuestionneur() {
        return questionneur;
    }

    public void setQuestionneur(String questionneur) {
        this.questionneur = questionneur;
    }

    public LocalDateTime getDateQuestion() {
        return dateQuestion;
    }

    public void setDateQuestion(LocalDateTime dateQuestion) {
        this.dateQuestion = dateQuestion;
    }

    public LocalDateTime getDateReponse() {
        return dateReponse;
    }

    public void setDateReponse(LocalDateTime dateReponse) {
        this.dateReponse = dateReponse;
    }

//    public LocalDateTime getDateVu() {
//        return dateVu;
//    }
//
//    public void setDateVu(LocalDateTime dateVu) {
//        this.dateVu = dateVu;
//    }


    public String getStatut() {
        return Statut;
    }

    public void setStatut(String statut) {
        Statut = statut;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public String getIdFiche() {
        return idFiche;
    }

    public void setIdFiche(String idFiche) {
        this.idFiche = idFiche;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id='" + id + '\'' +
                ", titre='" + titre + '\'' +
                ", Statut='" + Statut + '\'' +
                ", reponse='" + reponse + '\'' +
                ", usernamePatient='" + usernamePatient + '\'' +
                ", questionneur='" + questionneur + '\'' +
                ", idFiche='" + idFiche + '\'' +
                ", dateQuestion=" + dateQuestion +
                ", dateReponse=" + dateReponse +
                '}';
    }
}
