package com.bezkoder.spring.jwt.mongodb.payload.request;

public class SignupRequestPatient extends SignupRequest {

    private double taille;
    private double poids;
    private String chirurgienUsername;

    public String getChirurgienUsername() {
        return chirurgienUsername;
    }

    public void setChirurgienUsername(String chirurgienUsername) {
        this.chirurgienUsername = chirurgienUsername;
    }

    public double getTaille() {
        return taille;
    }

    public void setTaille(double taille) {
        this.taille = taille;
    }

    public double getPoids() {
        return poids;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }
}
