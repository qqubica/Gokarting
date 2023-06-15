package com.example.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;
import java.util.EnumSet;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Worker extends Person {
    @Column(nullable = false)
    private Date workStartDate;
    @Enumerated(EnumType.STRING)
    private WorkerRole workerRole;
    @OneToMany(mappedBy = "worker")
    private List<Ride> rides;

    public Worker(long id) {
        super(id);
    }
    public static EnumSet<WorkerRole> getWorkerRoles() {
        return EnumSet.allOf(WorkerRole.class);
    }

    public enum WorkerRole {
        MANAGER, TECHNICIAN, RECEPTIONIST, OWNER
    }
}

