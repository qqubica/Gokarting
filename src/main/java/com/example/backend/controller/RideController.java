package com.example.backend.controller;

import com.example.backend.model.DTO.RidePrepare;
import com.example.backend.service.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
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
}
