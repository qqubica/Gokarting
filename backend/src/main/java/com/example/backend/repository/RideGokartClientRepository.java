package com.example.backend.repository;

import com.example.backend.model.Client;
import com.example.backend.model.Ride;
import com.example.backend.model.RideGokartClient;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "rideGokartClient", path = "rideGokartClient")
@CrossOrigin(origins = "http://localhost:8081")
public interface RideGokartClientRepository extends ListCrudRepository<RideGokartClient, Long> {
    List<Client> findAllByClient(@RequestParam("client") Client client);
    List<RideGokartClient> findAllByRide(@RequestParam("ride") Ride ride);
}