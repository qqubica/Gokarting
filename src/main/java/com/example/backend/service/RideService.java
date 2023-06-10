package com.example.backend.service;

import com.example.backend.model.Ride;
import com.example.backend.model.Track;
import com.example.backend.repository.RideRepository;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;


@Service
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
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
    public List<Ride> getRidesToStart() {
        return rideRepository.findAllPlanedRides();
    }

    public void rideStartProcedure(Ride ride) {
        ride.setStartTime(new Date());
        rideRepository.save(ride);
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

