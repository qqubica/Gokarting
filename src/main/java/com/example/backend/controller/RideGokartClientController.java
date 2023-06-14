package com.example.backend.controller;

import com.example.backend.service.RideGokartClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
public class RideGokartClientController {
    private final RideGokartClientService rideGokartClientService;
    @Autowired
    public RideGokartClientController(RideGokartClientService rideGokartClientService) {
        this.rideGokartClientService = rideGokartClientService;
    }

    @PatchMapping("/updateRideGokartClient/{id}")
    public ResponseEntity updateRideGokartClient(@PathVariable("id") Long id, @RequestBody String jsonMap) {
        return rideGokartClientService.updateByRide(id, jsonMap);
    }
}
