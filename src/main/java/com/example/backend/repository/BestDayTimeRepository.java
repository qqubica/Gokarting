package com.example.backend.repository;

import com.example.backend.model.BestDayTime;
import com.example.backend.model.Worker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "bestDayTime", path = "bestDayTime")
public interface BestDayTimeRepository extends Repository<BestDayTime, Long>, CrudRepository<BestDayTime, Long> {

}