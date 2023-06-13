package com.example.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
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
    @OneToMany(mappedBy = "gokart")
    private List<Lap> laps;
    @ManyToOne(optional = false)
    private Localisation localisation;

    public enum GokartType {
        KIDS, SPORT, NORMAL, OTHER
    }
}

