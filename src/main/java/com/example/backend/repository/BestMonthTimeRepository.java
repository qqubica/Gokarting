package com.example.backend.repository;

import com.example.backend.model.BestDayTime;
import com.example.backend.model.BestMonthTime;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "bestMonthTime", path = "bestMonthTime")
public interface BestMonthTimeRepository extends Repository<BestMonthTime, Long>, CrudRepository<BestMonthTime, Long> {

}