package com.example.backend.repository;

import com.example.backend.model.Track;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "track", path = "track")
public interface TrackRepository extends Repository<Track, Long>, CrudRepository<Track, Long> {

}