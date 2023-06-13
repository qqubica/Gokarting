package com.example.backend.repository;

import com.example.backend.model.Worker;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(collectionResourceRel = "worker", path = "worker")
@CrossOrigin(origins = "http://localhost:8081")
public interface WorkerRepository extends ListCrudRepository<Worker, Long> {
}