package com.example.backend.controller;

import com.example.backend.model.Gokart;
import com.example.backend.model.Ride;
import com.example.backend.repository.GokartRepository;
import com.example.backend.repository.RideRepository;
import com.example.backend.service.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RideController {
    private final RideService rideService;
    private final RideRepository rideRepository;
    private final GokartRepository gokartRepository;

    @Autowired
    public RideController(RideService rideService, RideRepository rideRepository, GokartRepository gokartRepository) {
        this.rideService = rideService;
        this.gokartRepository = gokartRepository;
        this.rideRepository = rideRepository;
    }

    @GetMapping("/prepereRide/{id}")
    public List<Gokart> prepereRide(@PathVariable("id") Long id) {
        rideService.prepereRide(id);
        Ride r = rideRepository.findById(id).orElseThrow(()-> new RuntimeException("Ride " + id + " not found"));
        return gokartRepository.getGokartsByLocalisation(r.getTrack().getLocalisation());
    }
}
