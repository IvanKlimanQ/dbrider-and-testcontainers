package com.example.dbriderandtestcontainers.entity;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "Person", schema = "dbo")
public class PersonEntity {
    @Id
    @Column(name="ID")
    @Type(type = "uuid-char")
    private UUID id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Surname")
    private String surname;

    @Column(name = "Username")
    private String username;

    @Column(name = "Age")
    private Long age;

    @Column(name = "Eligible")
    private Boolean eligible;

    public PersonEntity(UUID id, String name, String surname, String username, Long age, Boolean eligible) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.age = age;
        this.eligible = eligible;
    }

    public PersonEntity() {

    }

    public UUID getId() {
        return id;
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
