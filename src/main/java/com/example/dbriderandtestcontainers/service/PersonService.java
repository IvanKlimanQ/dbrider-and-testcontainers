package com.example.dbriderandtestcontainers.service;

import com.example.dbriderandtestcontainers.util.PersonConverter;
import com.example.dbriderandtestcontainers.entity.PersonEntity;
import com.example.dbriderandtestcontainers.model.PersonModel;
import com.example.dbriderandtestcontainers.repository.PersonRepository;
import com.example.dbriderandtestcontainers.util.UuidGenerator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {
    private final PersonRepository personRepository;
    private final UuidGenerator uuidGenerator;

    public PersonService(PersonRepository personRepository, UuidGenerator uuidGenerator) {
        this.personRepository = personRepository;
        this.uuidGenerator = uuidGenerator;
    }

    public PersonModel createPerson(PersonModel personModel) {
        personModel.setId(this.uuidGenerator.generateUuid());
        return PersonConverter.toPersonModel(
                this.personRepository.save(PersonConverter.toPersonEntity(personModel)));
    }

    public List<PersonModel> getAllPersons() {
        List<PersonModel> personModels = new ArrayList<>();
        for (PersonEntity personEntity : this.personRepository.findAll()) {
            personModels.add(PersonConverter.toPersonModel(personEntity));
        }
        return personModels;
    }

    public PersonModel updatePerson(PersonModel personModel) {
        Optional<PersonEntity> entity = this.personRepository.findById(personModel.getId());
        if (entity.isPresent()) {
            return PersonConverter.toPersonModel(this.personRepository.save(PersonConverter.toPersonEntity(personModel)));
        }
        throw new IllegalArgumentException();
    }

    public void deletePerson(UUID personId) {
        Optional<PersonEntity> entity = this.personRepository.findById(personId);
        if(entity.isPresent()) {
            this.personRepository.deleteById(personId);
        }
    }
}
