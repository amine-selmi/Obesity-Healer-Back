package com.bezkoder.spring.jwt.mongodb.payload.request;

import java.time.LocalDateTime;

public class QuestionRequest {

    private String titre;
    private String statut;
    private String reponse;
    private String idFiche;
    private String questionneur;
    private String usernamePatient;
    private LocalDateTime dateQuestion;
    private LocalDateTime dateReponse;
   // private LocalDateTime dateVu;

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

    public String getQuestionneur() {
        return questionneur;
    }

    public void setQuestionneur(String questionneur) {
        this.questionneur = questionneur;
    }

    public String getUsernamePatient() {
        return usernamePatient;
    }

    public void setUsernamePatient(String usernamePatient) {
        this.usernamePatient = usernamePatient;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
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
}
