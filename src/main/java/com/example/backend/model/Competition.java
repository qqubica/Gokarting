package com.example.backend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;
@Data
@Entity
public class Competition {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false)
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CompetitionRank competitionRank;
    @ManyToOne(optional = false)
    private Localisation localisation;
    @OneToMany
    private Collection<Ride> rides;

    private enum CompetitionRank {
        INTERNATIONAL, NATIONAL, REGIONAL, LOCAL, OTHER, NO
    }
}
