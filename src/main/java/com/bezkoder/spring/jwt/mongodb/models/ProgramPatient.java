package com.bezkoder.spring.jwt.mongodb.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document("program-patient")
public class ProgramPatient {
    private String id;
    @JsonFormat(pattern="yyyy/MM/dd")
    private LocalDate dateDebut;
    @JsonFormat(pattern="yyyy/MM/dd")
    private LocalDate dateFin;
    private String type;
    private String description;
    private String usernamePatient;
    private String usernameMedecin;

    public ProgramPatient() {
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ProgramPatient{" +
                "id='" + id + '\'' +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
