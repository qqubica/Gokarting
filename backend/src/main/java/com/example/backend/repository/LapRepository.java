package com.example.backend.repository;

import com.example.backend.model.Lap;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(collectionResourceRel = "lap", path = "lap")
@CrossOrigin(origins = "http://localhost:8081")
public interface LapRepository extends ListCrudRepository<Lap, Long> {

}