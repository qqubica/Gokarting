package com.example.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Track {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false)
    private double length;
    @Column(nullable = false)
    private double avgSpeed;
    @Column(nullable = false)
    private int nrOfTurns;
    @ManyToOne(optional = false)
    private Localisation localisation;
    @OneToMany(mappedBy = "track")
    private List<Ride> ride;

    @Override
    public String toString() {
        return "Track{" +
                "id=" + id +
                ", length=" + length +
                ", avgSpeed=" + avgSpeed +
                ", nrOfTurns=" + nrOfTurns +
                '}';
    }
}