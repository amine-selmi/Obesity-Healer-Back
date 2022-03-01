package com.bezkoder.spring.jwt.mongodb.payload.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class RdvRequest {

    private String usernamePatient;

    private String usernameChirurgien;

    private String usernameMedecin;

    private String lieuxRdv;
    private String commentaire;
    private Boolean rdvEffectue;

    @JsonFormat(pattern="yyyy/MM/dd")
    private String dateRdv;

    private String idFiche;

    public String getIdFiche() {
        return idFiche;
    }

    public void setIdFiche(String idFiche) {
        this.idFiche = idFiche;
    }

    public String getDateRdv() {
        return dateRdv;
    }

    public void setDateRdv(String dateRdv) {
        this.dateRdv = dateRdv;
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

    public Boolean getRdvEffectue() {
        return rdvEffectue;
    }

    public void setRdvEffectue(Boolean rdvEffectue) {
        this.rdvEffectue = rdvEffectue;
    }
}
