package com.bezkoder.spring.jwt.mongodb.payload.request;

public class SignupRequestPersonnel extends SignupRequest {

    private String discipline;

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }
}
