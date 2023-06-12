package com.example.backend.repository;

import com.example.backend.model.Localisation;
import com.example.backend.model.Track;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "track", path = "track")
public interface TrackRepository extends Repository<Track, Long>, CrudRepository<Track, Long> {
    List<Track> getTrackByLocalisation(@RequestParam("localisation") Localisation localisation);
}