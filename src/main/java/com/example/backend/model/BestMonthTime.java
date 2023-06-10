package com.example.backend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class BestMonthTime extends BestTime {
    @Column(nullable = false)
    private Date recordMonth;
}