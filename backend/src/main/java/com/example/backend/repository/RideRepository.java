package com.example.backend.repository;

import com.example.backend.model.Ride;
import com.example.backend.model.Track;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "ride", path = "ride")
@CrossOrigin(origins = "http://localhost:8081")
public interface RideRepository extends ListCrudRepository<Ride, Long> {
    List<Ride> findByTrackAndRideStatus(@Param("track") Track track, @Param("rideStatus") Ride.RideStatus rideStatus);

    List<Ride> findByTrack(@Param("track") Track track);
}