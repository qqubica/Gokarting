package com.example.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
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
    @OneToMany(mappedBy = "competition")
    private List<Ride> rides;

    private enum CompetitionRank {
        INTERNATIONAL, NATIONAL, REGIONAL, LOCAL, OTHER, NO
    }
}
