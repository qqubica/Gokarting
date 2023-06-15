package com.example.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Localisation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false)
    private String name;
    @OneToMany(mappedBy = "localisation")
    private List<Track> tracks;
    @OneToMany(mappedBy = "localisation")
    private List<Competition> competitions;
    @OneToMany(mappedBy = "localisation")
    private List<Gokart> gokarts;

    @Override
    public String toString() {
        return "Localisation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}