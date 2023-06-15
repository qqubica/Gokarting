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
    @OneToOne(mappedBy = "lap", cascade = CascadeType.ALL)
    private BestDayTime bestDayTime;
    @OneToOne(mappedBy = "lap", cascade = CascadeType.ALL)
    private BestMonthTime bestMonthTime;

    public void setNumber(int number) {
//        numer okrążenia nie może być ujemny
        if (number < 0) {
            throw new IllegalArgumentException("Number cannot be negative");
        }

        this.number = number;
    }
}