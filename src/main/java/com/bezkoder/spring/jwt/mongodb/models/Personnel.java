package com.bezkoder.spring.jwt.mongodb.models;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("Personnel")
public class Personnel extends User{


    private String discipline;

    public Personnel(String nom, String prenom, long numTel,
                     String dateNaissance, String username,
                     String email, String password,
                     Role roles, String discipline) {
        super(nom, prenom, numTel, dateNaissance, username, email, password, roles);
        this.discipline = discipline;
    }

    public Personnel() {
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }
}

