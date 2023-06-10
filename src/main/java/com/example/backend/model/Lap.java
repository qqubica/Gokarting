package com.example.backend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Duration;
@Data
@Entity
public class Lap {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false)
    private int number;
    @Column(nullable = false)
    private Duration time;
    @OneToOne
    private BestDayTime bestDayTime;
    @OneToOne
    private BestMonthTime bestMonthTime;
    @ManyToOne(optional = false)
    private Gokart gokart;
}