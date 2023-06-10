package com.example.backend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;
import java.util.Date;
@Entity
@Data
public class Ride {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Date startTime;
    private int duration;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RideStatus rideStatus = RideStatus.CREATED;
    @Enumerated(EnumType.STRING)
    private RideType rideType;
    @ManyToOne
    private Competition competition;
    @ManyToOne(optional = false)
    private Track track;
    @OneToMany
    private Collection<RideGokartClient> rideGokartClients;
    @ManyToOne
    private Worker worker;

    enum RideStatus {
        CREATED, PLANED, IN_PROGRESS, FINISHED, CANCLED, OTHER
    }

    public enum RideType {
        RACE, NORMAL, TECHNICAL, OTHER
    }
}