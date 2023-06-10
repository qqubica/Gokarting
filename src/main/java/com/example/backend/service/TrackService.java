package com.example.backend.service;

import com.example.backend.model.Localisation;
import com.example.backend.model.Track;
import com.example.backend.repository.TrackRepository;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class TrackService {
    TrackRepository trackRepository;
    @Autowired
    public TrackService(TrackRepository trackRepository, LocalisationService localisationService){
        this.trackRepository = trackRepository;
        if (this.trackRepository.count()==0) {
            createRandomTrack(5, localisationService);
            System.out.println("Populated track repository with random data.");
        }
    }
    public void createRandomTrack(int n, LocalisationService localisationService) {
        Random random = new Random();
        List<Localisation> localisations = localisationService.getLocalisationsList();
        for (int i = 0; i < n; i++) {
            Track track = new Track();

            track.setAvgSpeed(random.nextDouble(80));
            track.setLength(random.nextInt(1000));
            track.setNrOfTurns(random.nextInt(25));
            track.setLocalisation(localisations.get(random.nextInt(localisations.size())));

            trackRepository.save(track);
        }
    }

    public List<Track> getTracks() {
        return StreamSupport.stream(trackRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public int getTracksCount() {
        return (int) trackRepository.count();
    }
}
