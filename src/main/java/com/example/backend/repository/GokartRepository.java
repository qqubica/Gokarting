package com.example.backend.repository;

import com.example.backend.model.Gokart;
import com.example.backend.model.Localisation;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "gokart", path = "gokart")
@CrossOrigin(origins = "http://localhost:8081")
public interface GokartRepository extends ListCrudRepository<Gokart, Long> {
    List<Gokart> getGokartsByLocalisation(Localisation localisation);
}