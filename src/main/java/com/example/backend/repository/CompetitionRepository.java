package com.example.backend.repository;

import com.example.backend.model.Competition;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "competition", path = "competition")
public interface CompetitionRepository extends ListCrudRepository<Competition, Long> {

}