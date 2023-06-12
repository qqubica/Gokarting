package com.example.backend.service;

import com.example.backend.model.Gokart;
import com.example.backend.model.Localisation;
import com.example.backend.repository.GokartRepository;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class GokartService {
    GokartRepository gokartRepository;
    @Autowired
    public GokartService(GokartRepository gokartRepository, LocalisationService localisationService) {
        this.gokartRepository = gokartRepository;
        if (gokartRepository.count() == 0) {
            populateWithRandomData(10, localisationService);
            System.out.println("Populated gokart repository with random data.");
        }
    }
    public void populateWithRandomData(int n, LocalisationService localisationService) {
        Random random = new Random();
        List<Localisation> localisations = localisationService.getLocalisationsList();
        for (int i = 0; i < n; i++) {
            Gokart gokart = new Gokart();

            gokart.setHorsepower(random.nextInt(100));
            gokart.setTypGokarta(Gokart.GokartType.values()[random.nextInt(Gokart.GokartType.values().length)]);
            Localisation randomLoc = localisations.get(random.nextInt(localisations.size()));
            gokart.setLocalisation(randomLoc);

            gokartRepository.save(gokart);
        }
    }
}
