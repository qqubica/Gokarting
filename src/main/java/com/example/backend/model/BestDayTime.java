package com.example.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Entity
@Data
public class BestDayTime extends BestTime {
    @Column(nullable = false)
    private Date recordDay;
}