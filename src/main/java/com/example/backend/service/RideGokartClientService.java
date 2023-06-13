package com.example.backend.service;

import com.example.backend.model.Client;
import com.example.backend.model.Ride;
import com.example.backend.model.RideGokartClient;
import com.example.backend.repository.RideGokartClientRepository;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class RideGokartClientService {
    RideGokartClientRepository rideGokartClientRepository;
    @Autowired
    public RideGokartClientService(RideGokartClientRepository rideGokartClientRepository, ClientService clientService, RideService rideService) {
        this.rideGokartClientRepository = rideGokartClientRepository;
        if (rideGokartClientRepository.count() == 0) {
            addRandomData(30, clientService, rideService);
            System.out.println("Populated rideGokartClient repository with random data.");
        }
    }

    public void addRandomData(int n, ClientService clientService, RideService rideService) {
        Random random = new Random();
        List<Client> clients =  clientService.getClientsList();
        List<Ride> rides = rideService.getRidesList();

        for (int i = 0; i < n; i++) {
            RideGokartClient rideGokartClient = new RideGokartClient();

            rideGokartClient.setClient(clients.get(random.nextInt(clients.size())));

            rideGokartClient.setRide(rides.get(random.nextInt(rides.size())));

            rideGokartClientRepository.save(rideGokartClient);
        }
    }
}
