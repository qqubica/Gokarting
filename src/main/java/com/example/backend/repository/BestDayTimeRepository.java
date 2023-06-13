package com.example.backend.repository;

import com.example.backend.model.BestDayTime;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(collectionResourceRel = "bestDayTime", path = "bestDayTime")
public interface BestDayTimeRepository extends ListCrudRepository<BestDayTime, Long> {

}