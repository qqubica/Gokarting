package com.example.backend.service;

import com.example.backend.model.Localisation;
import com.example.backend.repository.LocalisationRepository;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class LocalisationService {
    LocalisationRepository localisationRepository;
    @Autowired
    public LocalisationService(LocalisationRepository localisationRepository) {
        this.localisationRepository = localisationRepository;
        if (this.localisationRepository.count() == 0) {
            addRandomData(5);
            System.out.println("Populated localisation repository with random data.");
        }
    }

    public List<Localisation> getLocalisationsList() {
        return localisationRepository.findAll();
    }

    public void addRandomData(int records) {
        Random random = new Random();
        for (int i = 0; i < records; i++) {
            Localisation localisation = new Localisation();
            localisation.setName(randomString(random.nextInt(100)));
            localisationRepository.save(localisation);
        }
    }

    public String randomString(int targetStringLength) {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString.toUpperCase();
    }
}
