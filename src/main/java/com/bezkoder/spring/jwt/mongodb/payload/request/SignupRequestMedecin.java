package com.bezkoder.spring.jwt.mongodb.payload.request;

public class SignupRequestMedecin extends SignupRequest {

    private long numeroRPS;
    private String discipline;
    private String lieuxConsultation;

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
