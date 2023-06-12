package com.example.backend.repository;

import com.example.backend.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "client", path = "client")
public interface ClientRepository extends ListCrudRepository<Client, Long> {
}