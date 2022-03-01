package com.bezkoder.spring.jwt.mongodb.payload.request;

import java.time.LocalDate;

public class ProgramPatientRequest {

    private String dateDebut;
    private String dateFin;
    private String type;
    private String description;
    private String usernamePatient;
    private String usernameMedecin;

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
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

    public String getUsernamePatient() {
        return usernamePatient;
    }

    public void setUsernamePatient(String usernamePatient) {
        this.usernamePatient = usernamePatient;
    }

    public String getUsernameMedecin() {
        return usernameMedecin;
    }

    public void setUsernameMedecin(String usernameMedecin) {
        this.usernameMedecin = usernameMedecin;
    }
}
