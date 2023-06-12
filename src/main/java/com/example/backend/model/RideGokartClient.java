package com.example.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
public class RideGokartClient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    private Ride ride;
    @ManyToOne
    private Gokart gokart;
    @ManyToOne
    private Client client;
    @OneToMany
    private Collection<Lap> laps;
}