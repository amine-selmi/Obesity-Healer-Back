package com.bezkoder.spring.jwt.mongodb.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("fichePatient")
public class FichePatient {

    @Id
    private String id;

    private String usernamePatient;

    private String usernameChirurgien;

    private String usernameMedecin;

    private String ficheBody;
//    @DBRef
//    private List<Question> questions;


    public FichePatient() {
    }

//    public List<Question> getQuestions() {
//        return questions;
//    }
//
//    public void setQuestions(List<Question> questions) {
//        this.questions = questions;
//    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsernamePatient() {
        return usernamePatient;
    }

    public void setUsernamePatient(String usernamePatient) {
        this.usernamePatient = usernamePatient;
    }

    public String getUsernameChirurgien() {
        return usernameChirurgien;
    }

    public void setUsernameChirurgien(String usernameChirurgien) {
        this.usernameChirurgien = usernameChirurgien;
    }

    public String getUsernameMedecin() {
        return usernameMedecin;
    }

    public void setUsernameMedecin(String usernameMedecin) {
        this.usernameMedecin = usernameMedecin;
    }

    public String getFicheBody() {
        return ficheBody;
    }

    public void setFicheBody(String ficheBody) {
        this.ficheBody = ficheBody;
    }

    @Override
    public String toString() {
        return "FichePatient{" +
                "id='" + id + '\'' +
                ", usernamePatient='" + usernamePatient + '\'' +
                ", usernameChirurgien='" + usernameChirurgien + '\'' +
                ", usernameMedecin='" + usernameMedecin + '\'' +
                ", ficheBody='" + ficheBody + '\'' +
                '}';
    }
}
