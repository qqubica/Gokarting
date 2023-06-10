package com.example.backend.model;

import com.example.backend.model.Lap;
import jakarta.persistence.*;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Collection;

@MappedSuperclass
@Data
public abstract class BestTime {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @OneToOne(optional = false)
    private Lap lap;
}