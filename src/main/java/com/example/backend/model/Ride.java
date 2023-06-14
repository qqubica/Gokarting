package com.example.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import static jakarta.persistence.FetchType.EAGER;

@Entity
@Data
@NoArgsConstructor
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
    @OneToMany(mappedBy = "ride")
    private List<RideGokartClient> rideDetails;
    @ManyToOne
    private Worker worker;

    public Ride(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Ride{" +
                "id=" + id +
                ", startTime=" + startTime +
                ", duration=" + duration +
                ", rideStatus=" + rideStatus +
                ", rideType=" + rideType +
                ", competition=" + competition +
                ", track=" + track +
                ", worker=" + worker +
                '}';
    }

    public enum RideStatus {
        CREATED, PREPERING, IN_PROGRESS, FINISHED, CANCLED, OTHER
    }

    public enum RideType {
        RACE, NORMAL, TECHNICAL, OTHER
    }
}