package com.example.backend.repository;

import com.example.backend.model.Client;
import com.example.backend.model.Worker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "client", path = "client")
public interface ClientRepository extends Repository<Client, Long>, CrudRepository<Client, Long> {

}