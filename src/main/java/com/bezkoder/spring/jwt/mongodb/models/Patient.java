package com.bezkoder.spring.jwt.mongodb.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("patient")
public class Patient extends User{

    private double taille;
    private double poids;
    private String chirurgienUsername;

    public Patient(double taille, double poids, String chirurgienUsername ) {
        this.taille = taille;
        this.poids = poids;
        this.chirurgienUsername = chirurgienUsername;
    }
    public Patient() {

    }

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

