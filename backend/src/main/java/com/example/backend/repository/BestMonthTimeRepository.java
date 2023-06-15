package com.example.backend.repository;

import com.example.backend.model.BestMonthTime;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(collectionResourceRel = "bestMonthTime", path = "bestMonthTime")
@CrossOrigin(origins = "http://localhost:8081")
public interface BestMonthTimeRepository extends ListCrudRepository<BestMonthTime, Long> {

}