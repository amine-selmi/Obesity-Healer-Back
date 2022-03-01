package com.bezkoder.spring.jwt.mongodb.payload.request;

public class FicheRequest {

    private String usernamePatient;

    private String usernameChirurgien;

    private String usernameMedecin;

    private String ficheBody;

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
}
