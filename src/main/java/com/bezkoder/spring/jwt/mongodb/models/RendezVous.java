package com.bezkoder.spring.jwt.mongodb.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document("Rendez-vous")
public class RendezVous {

    @Id
    private String id;

    @JsonFormat(pattern="yyyy/MM/dd")
    private LocalDate dateRdv;

    private String lieuxRdv;
    private String commentaire;
    private Boolean rdvEffectue;
    private String usernameMedecin;

    private String usernamePatient;

    private String usernameChirurgien;

    private String idFiche;


    public RendezVous() {
    }

    public String getIdFiche() {
        return idFiche;
    }

    public void setIdFiche(String idFiche) {
        this.idFiche = idFiche;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    public String getLieuxRdv() {
        return lieuxRdv;
    }

    public void setLieuxRdv(String lieuxRdv) {
        this.lieuxRdv = lieuxRdv;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public String getDateRdv() {
        return dateRdv.toString();
    }

    public void setDateRdv(LocalDate dateRdv) {
        this.dateRdv = dateRdv;
    }
    public Boolean getRdvEffectue() {
        return rdvEffectue;
    }

    public void setRdvEffectue(Boolean rdvEffectue) {
        this.rdvEffectue = rdvEffectue;
    }

    public String getUsernameMedecin() {
        return usernameMedecin;
    }

    public void setUsernameMedecin(String usernameMedecin) {
        this.usernameMedecin = usernameMedecin;
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
}
