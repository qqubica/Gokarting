package com.example.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;

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
    @OneToMany(mappedBy = "rideGokartClient")
    private List<Lap> laps;

    @Override
    public String toString() {
        return "RideGokartClient{" +
                "id=" + id +
                ", ride=" + ride +
                '}';
    }
}