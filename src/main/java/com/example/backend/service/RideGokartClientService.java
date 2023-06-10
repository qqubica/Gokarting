package com.example.backend.service;

import com.example.backend.model.Client;
import com.example.backend.model.RideGokartClient;
import com.example.backend.repository.RideGokartClientRepository;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class RideGokartClientService {
    RideGokartClientRepository rideGokartClientRepository;
    @Autowired
    public RideGokartClientService(RideGokartClientRepository rideGokartClientRepository, ClientService clientService) {
        this.rideGokartClientRepository = rideGokartClientRepository;
        if (rideGokartClientRepository.count() == 0) {
            addRandomData(5, clientService);
            System.out.println("Populated rideGokartClient repository with random data.");
        }
    }

    public void addRandomData(int n, ClientService clientService){
        Random random = new Random();
        List<Client> clients =  clientService.getClientsList();
        for (int i = 0; i < n; i++) {
            RideGokartClient rideGokartClient = new RideGokartClient();

            rideGokartClient.setClient(clients.get(random.nextInt(clients.size())));

            rideGokartClientRepository.save(rideGokartClient);
        }
    }


}
