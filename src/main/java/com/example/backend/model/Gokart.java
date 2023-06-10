package com.example.backend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;
import java.util.List;
@Data
@Entity
public class Gokart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false)
    private int horsepower;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private GokartType typGokarta;
    @OneToMany
    private Collection<Lap> laps;

    private enum GokartType {
        KIDS, SPORT, NORMAL, OTHER
    }
}
