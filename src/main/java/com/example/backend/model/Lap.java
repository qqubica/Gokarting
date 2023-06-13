package com.example.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
@Data
@Entity
@NoArgsConstructor
public class Lap {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false)
    private int number;
    @Column(nullable = false)
    private Duration time;
    @ManyToOne(optional = false)
    private RideGokartClient rideGokartClient;
    @OneToOne(mappedBy = "lap")
    private BestDayTime bestDayTime;
    @OneToOne(mappedBy = "lap")
    private BestMonthTime bestMonthTime;

}