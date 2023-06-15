package com.example.backend.repository;

import com.example.backend.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "client", path = "client")
@CrossOrigin(origins = "http://localhost:8081")
public interface ClientRepository extends ListCrudRepository<Client, Long> {
}