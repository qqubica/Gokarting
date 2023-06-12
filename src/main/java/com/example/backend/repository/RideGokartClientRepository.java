package com.example.backend.repository;

import com.example.backend.model.Client;
import com.example.backend.model.RideGokartClient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "rideGokartClient", path = "rideGokartClient")
public interface RideGokartClientRepository extends ListCrudRepository<RideGokartClient, Long> {
    List<Client> findAllByClient(@RequestParam("client") Client client);
}