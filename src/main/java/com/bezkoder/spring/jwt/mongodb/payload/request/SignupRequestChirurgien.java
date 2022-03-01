package com.bezkoder.spring.jwt.mongodb.payload.request;

public class SignupRequestChirurgien extends SignupRequest{

    private String civilite;
    private String adresseAdomicile;
    private long numTelAdomicile;
    private long numTelPersonnel;
    private long numeroRPS;
    private String discipline;
    private String lieuxConsultation;
    private String lieuxInterventionChirurgicale;

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
