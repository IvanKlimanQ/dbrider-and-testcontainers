package com.example.dbriderandtestcontainers.repository;

import com.example.dbriderandtestcontainers.entity.PersonEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PersonRepository extends CrudRepository<PersonEntity, UUID> {
}
