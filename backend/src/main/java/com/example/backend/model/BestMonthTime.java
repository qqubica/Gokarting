package com.example.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class BestMonthTime extends BestTime {
    @Column(nullable = false)
    private Date recordMonth;
}