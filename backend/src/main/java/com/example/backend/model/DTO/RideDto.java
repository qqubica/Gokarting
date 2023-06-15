package com.example.backend.model.DTO;

import com.example.backend.model.Ride;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class RideDto {
    private long id;
    private Date startTime;
    private int duration;
    private Ride.RideStatus rideStatus;
    private Ride.RideType rideType;

    public RideDto(Ride r) {
        this.id = r.getId();
        this.startTime = r.getStartTime();
        this.duration = r.getDuration();
        this.rideStatus = r.getRideStatus();
        this.rideType = r.getRideType();
    }
}
