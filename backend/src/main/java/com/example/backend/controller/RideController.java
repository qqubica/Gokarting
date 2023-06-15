package com.example.backend.controller;

import com.example.backend.model.DTO.RideDto;
import com.example.backend.model.DTO.RidePrepare;
import com.example.backend.service.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "http://localhost:8081")
public class RideController {
    private final RideService rideService;

    @Autowired
    public RideController(RideService rideService) {
        this.rideService = rideService;
    }

    @GetMapping("/prepereRide/{id}")
    public RidePrepare prepereRide(@PathVariable("id") Long id) {
        return rideService.prepereRide(id);
    }

    @GetMapping("/startRide/{rideId}/{workerId}")
    public RideDto startRide(@PathVariable("rideId") Long rideId, @PathVariable("workerId") Long workerId) {
        return rideService.startRide(rideId, workerId);
    }
}
