package com.example.dbriderandtestcontainers.util;

import com.example.dbriderandtestcontainers.entity.PersonEntity;
import com.example.dbriderandtestcontainers.model.PersonModel;

public class PersonConverter {
    public static PersonModel toPersonModel(PersonEntity entity) {
        return new PersonModel(
                entity.getId(),
                entity.getName(),
                entity.getSurname(),
                entity.getUsername(),
                entity.getAge(),
                entity.getEligible()
        );
    }

    public static PersonEntity toPersonEntity(PersonModel personModel) {
        return new PersonEntity(
                personModel.getId(),
                personModel.getName(),
                personModel.getSurname(),
                personModel.getUsername(),
                personModel.getAge(),
                personModel.getEligible()
        );
    }
}
