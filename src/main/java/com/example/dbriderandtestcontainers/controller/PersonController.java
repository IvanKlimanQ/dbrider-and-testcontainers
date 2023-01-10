package com.example.dbriderandtestcontainers.controller;

import com.example.dbriderandtestcontainers.model.PersonModel;
import com.example.dbriderandtestcontainers.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/person")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity<PersonModel> createPerson(@RequestBody PersonModel personModel) {
        return ResponseEntity.ok(this.personService.createPerson(personModel));
    }

    @GetMapping
    public ResponseEntity<List<PersonModel>> getAllPersons() {
        return ResponseEntity.ok(this.personService.getAllPersons());
    }

    @PutMapping
    public ResponseEntity<PersonModel> updatePerson(@RequestBody PersonModel personModel) {
        return ResponseEntity.ok(this.personService.updatePerson(personModel));
    }

    @DeleteMapping("/{person-id}")
    public ResponseEntity<Void> deletePerson(@PathVariable("person-id") UUID personId) {
        this.personService.deletePerson(personId);
        return ResponseEntity.ok(null);
    }
}
