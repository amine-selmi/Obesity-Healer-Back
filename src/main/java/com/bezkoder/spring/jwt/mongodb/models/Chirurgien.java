package com.bezkoder.spring.jwt.mongodb.models;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Set;

@Document("chirurgien")
public class Chirurgien extends User{

    private String civilite;
    private String adresseAdomicile;
    private long numTelAdomicile;
    private long numTelPersonnel;
    private long numeroRPS;
    private String discipline;
    private String lieuxConsultation;
    private String lieuxInterventionChirurgicale;

    public Chirurgien(String nom, String prenom, long numTel,
                      String dateNaissance, String username,
                      String email, String password, Role roles,
                      String civilite, String adresseAdomicile,
                      long numTelAdomicile, long numTelPersonnel,
                      long numeroRPS, String discipline, String lieuxConsultation,
                      String lieuxInterventionChirurgicale) {
        super(nom, prenom, numTel, dateNaissance, username, email, password, roles);
        this.civilite = civilite;
        this.adresseAdomicile = adresseAdomicile;
        this.numTelAdomicile = numTelAdomicile;
        this.numTelPersonnel = numTelPersonnel;
        this.numeroRPS = numeroRPS;
        this.discipline = discipline;
        this.lieuxConsultation = lieuxConsultation;
        this.lieuxInterventionChirurgicale = lieuxInterventionChirurgicale;
    }

    public Chirurgien() {
    }

    public String getCivilite() {
        return civilite;
    }

    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }

    public String getAdresseAdomicile() {
        return adresseAdomicile;
    }

    public void setAdresseAdomicile(String adresseAdomicile) {
        this.adresseAdomicile = adresseAdomicile;
    }

    public long getNumTelAdomicile() {
        return numTelAdomicile;
    }

    public void setNumTelAdomicile(long numTelAdomicile) {
        this.numTelAdomicile = numTelAdomicile;
    }

    public long getNumTelPersonnel() {
        return numTelPersonnel;
    }

    public void setNumTelPersonnel(long numTelPersonnel) {
        this.numTelPersonnel = numTelPersonnel;
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

    public String getLieuxInterventionChirurgicale() {
        return lieuxInterventionChirurgicale;
    }

    public void setLieuxInterventionChirurgicale(String lieuxInterventionChirurgicale) {
        this.lieuxInterventionChirurgicale = lieuxInterventionChirurgicale;
    }
}
