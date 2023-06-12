package com.example.backend.repository;

import com.example.backend.model.Localisation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "localisation", path = "localisation")
public interface LocalisationRepository extends ListCrudRepository<Localisation, Long> {
}