package com.example.backend.service;

import com.example.backend.model.*;
import com.example.backend.model.DTO.GokartDTO;
import com.example.backend.model.DTO.RidePrepare;
import com.example.backend.repository.RideRepository;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
@CrossOrigin(origins = "http://localhost:8081")
public class RideService {
    RideRepository rideRepository;
    @Autowired
    public RideService(RideRepository rideRepository, TrackService trackService) {
        this.rideRepository = rideRepository;
        if (rideRepository.count() == 0) {
            createRandomRides(10, trackService);
            System.out.println("Populated ride repository with random data.");
        }
    }
    public RidePrepare prepereRide(Long id) {

        Optional<Ride> optionalRide = rideRepository.findById(id);
        Ride ride = optionalRide.orElseThrow(() -> new RuntimeException("Ride " + id + " not found"));

        if (ride.getRideStatus() != Ride.RideStatus.CREATED) {
            return null;
        }

        ride.setRideStatus(Ride.RideStatus.PREPERING);
        rideRepository.save(ride);

        List<Client> clients = ride.getRideDetails().stream().map(r -> r.getClient()).toList();
        List<GokartDTO> gokarts = ride.getTrack().getLocalisation().getGokarts().stream().map(g -> new GokartDTO(g)).toList();

        System.out.println(gokarts);
        return new RidePrepare(gokarts, clients);
    }
    public List<Ride> getRidesList() {
        return rideRepository.findAll();
    }

    public void createRandomRides(int n, TrackService trackService) {
        Random random = new Random();
        List<Track> tracks =  trackService.getTracks();

        for (int i = 0; i < n; i++) {
            Ride ride = new Ride();

            if (random.nextBoolean()){
                ride.setDuration(random.nextInt(100));
            }

            Track randomTrack = tracks.get(random.nextInt(tracks.size()));
            ride.setTrack(randomTrack);

            ride.setRideType(Ride.RideType.values()[random.nextInt(Ride.RideType.values().length)]);

            ride.setRideType(Ride.RideType.values()[random.nextInt(Ride.RideType.values().length)]);

            rideRepository.save(ride);
        }
    }
}

