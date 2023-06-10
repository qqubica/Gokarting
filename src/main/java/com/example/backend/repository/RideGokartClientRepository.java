package com.example.backend.repository;

import com.example.backend.model.RideGokartClient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "rideGokartClient", path = "rideGokartClient")
public interface RideGokartClientRepository extends Repository<RideGokartClient, Long>, CrudRepository<RideGokartClient, Long> {

}