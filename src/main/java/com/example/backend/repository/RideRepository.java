package com.example.backend.repository;

import com.example.backend.model.Ride;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "ride", path = "ride")
public interface RideRepository extends Repository<Ride, Long>, CrudRepository<Ride, Long> {

}