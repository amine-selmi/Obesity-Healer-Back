package com.bezkoder.spring.jwt.mongodb.models;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("Medecin")
public class Medecin extends User{

    private long numeroRPS;
    private String discipline;
    private String lieuxConsultation;

    public Medecin(String nom, String prenom, long numTel, String dateNaissance,
                   String username, String email, String password, Role roles,
                   long numeroRPS, String discipline, String lieuxConsultation) {
        super(nom, prenom, numTel, dateNaissance, username, email, password, roles);
        this.numeroRPS = numeroRPS;
        this.discipline = discipline;
        this.lieuxConsultation = lieuxConsultation;
    }

    public Medecin() {
    }

    public long getNumeroRPS() {
        return numeroRPS;
    }

    public void setNumeroRPS(long numeroRPS) {
        this.numeroRPS = numeroRPS;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public String getLieuxConsultation() {
        return lieuxConsultation;
    }

    public void setLieuxConsultation(String lieuxConsultation) {
        this.lieuxConsultation = lieuxConsultation;
    }
}

