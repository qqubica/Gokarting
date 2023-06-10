package com.example.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class BestDayTime extends BestTime {
    @Column(nullable = false)
    private Date recordDay;
}