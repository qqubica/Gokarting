package com.example.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
@Data
@Entity
@NoArgsConstructor
public class Localisation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false)
    private String name;
    @OneToMany
    private Collection<Track> tracks;
    @OneToMany
    private Collection<Competition> competitions;
    @OneToMany
    private Collection<Gokart> gokarts;
}