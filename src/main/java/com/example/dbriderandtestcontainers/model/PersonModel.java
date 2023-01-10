package com.example.dbriderandtestcontainers.model;

import java.util.UUID;

public class PersonModel {

    private UUID id;
    private String name;
    private String surname;
    private String username;
    private Long age;
    private Boolean eligible;

    public PersonModel(UUID id, String name, String surname, String username, Long age, Boolean eligible) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.age = age;
        this.eligible = eligible;
    }

    public PersonModel(String name, String surname, String username, Long age, Boolean eligible) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.age = age;
        this.eligible = eligible;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getUsername() {
        return username;
    }
    public Long getAge() {
        return age;
    }

    public Boolean getEligible() {
        return eligible;
    }
}