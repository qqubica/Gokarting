package com.example.backend.repository;

import com.example.backend.model.Lap;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "lap", path = "lap")
public interface LapRepository extends Repository<Lap, Long>, CrudRepository<Lap, Long> {

}