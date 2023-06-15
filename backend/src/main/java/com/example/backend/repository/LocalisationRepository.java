package com.example.backend.repository;

import com.example.backend.model.Localisation;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(collectionResourceRel = "localisation", path = "localisation")
@CrossOrigin(origins = "http://localhost:8081")
public interface LocalisationRepository extends ListCrudRepository<Localisation, Long> {
}