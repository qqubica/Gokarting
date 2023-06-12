package com.example.backend.repository;

import com.example.backend.model.Gokart;
import com.example.backend.model.Localisation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "gokart", path = "gokart")
public interface GokartRepository extends ListCrudRepository<Gokart, Long> {
    List<Gokart> getGokartsByLocalisation(Localisation localisation);
}