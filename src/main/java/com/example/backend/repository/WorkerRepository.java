package com.example.backend.repository;

import com.example.backend.model.Worker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "worker", path = "worker")
public interface WorkerRepository extends ListCrudRepository<Worker, Long> {
}