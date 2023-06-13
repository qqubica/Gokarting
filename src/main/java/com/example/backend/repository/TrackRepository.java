package com.example.backend.repository;

import com.example.backend.model.Localisation;
import com.example.backend.model.Track;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "track", path = "track")
@CrossOrigin(origins = "http://localhost:8081")
public interface TrackRepository extends ListCrudRepository<Track, Long> {
    List<Track> getTrackByLocalisation(@RequestParam("localisation") Localisation localisation);
}