package com.example.backend.service;

import com.example.backend.model.Client;
import com.example.backend.model.Gokart;
import com.example.backend.model.Ride;
import com.example.backend.model.RideGokartClient;
import com.example.backend.repository.RideGokartClientRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.*;

@Service
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
@CrossOrigin(origins = "http://localhost:8081")
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

    public ResponseEntity updateByRide(Long id, String jsonMap) {
        List<RideGokartClient> list = rideGokartClientRepository.findAllByRide(new Ride(id));
//        map clientId gokartId
        Map<String, Integer> map = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            map = objectMapper.readValue(jsonMap, Map.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        for (RideGokartClient rideGokartClient : list) {
            String clientId = String.valueOf(rideGokartClient.getClient().getId());
            long gokartId = map.get(clientId);

            rideGokartClient.setGokart(new Gokart(gokartId));

            rideGokartClientRepository.save(rideGokartClient);
        }
        return ResponseEntity.noContent().build();
    }

    public void addRandomData(int n, ClientService clientService, RideService rideService) {
        Random random = new Random();
        List<Client> clients =  clientService.getClientsList();
        List<Ride> rides = rideService.getRidesList();

        for (int i = 0; i < n; i++) {
            RideGokartClient rideGokartClient = new RideGokartClient();

            int randomClientId = random.nextInt(clients.size());
            int rideId = random.nextInt(rides.size());

            rideGokartClient.setRide(rides.get(rideId));


            rideGokartClient.setClient(clients.get(randomClientId));

            rideGokartClientRepository.save(rideGokartClient);
        }
    }
}
