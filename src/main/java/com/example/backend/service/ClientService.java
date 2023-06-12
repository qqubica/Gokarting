package com.example.backend.service;

import com.example.backend.model.Client;
import com.example.backend.model.Ride;
import com.example.backend.repository.ClientRepository;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class ClientService {
    ClientRepository clientRepository;
    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
        if (clientRepository.count() == 0) {
            addRandomClients(10);
            System.out.println("Populated client repository with random data.");
        }
    }

    public void addRandomClients(int n) {
        String[] names = {"Jan", "Emilia", "Michal", "Zosia", "Wilson"};
        String[] lastNames = {"Smith", "Kowalski", "Wudarski", "Taylor", "Anderson"};

        Random random = new Random();

        for (int i = 0; i < n; i++) {
            Client client = new Client();

            // Generate random name and last name
            String name = names[random.nextInt(names.length)];
            String lastName = lastNames[random.nextInt(lastNames.length)];

            client.setName(name);
            client.setSurname(lastName);

            // Generate random email
            String email = name.toLowerCase() + "." + lastName.toLowerCase() + random.nextDouble() + "@example.com";
            client.setEmail(email);

            // Generate random password
            String password = client.getEmail() + "123";
            client.setPassword(password);

            // Generate random work start date (within the last year)
            Date currentDate = new Date();
            long oneYearInMillis = 365L * 24 * 60 * 60 * 1000;
            long randomMillis = (long) (random.nextDouble() * oneYearInMillis);
            Date workStartDate = new Date(currentDate.getTime() - randomMillis);

            clientRepository.save(client);
        }
    }

    public List<Client> getClientsList() {
        return clientRepository.findAll();
    }
}
