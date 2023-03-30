package com.project.happy_fly.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name="circuit")
public class Circuit {
    @Id
    @Basic
    @Column(name="name", length=100, nullable=false)
    private String name;

    @Column(name="description", nullable=false, columnDefinition="text")
    private String description;

    @Basic
    @Column(name="duration_day", nullable=false)
    private int durationDay;

    @Column(name="registration_cost", nullable=false)
    private float registrationCost;

    @Temporal(TemporalType.DATE)
    @Column(name="deaparture_date", nullable=false)
    private Date deapartureDate;

    @Temporal(TemporalType.DATE)
    @Column(name="arrival_date", nullable=false)
    private Date arrivalDate;

    @OneToMany(mappedBy="circuit", cascade=CascadeType.ALL, orphanRemoval=true)
    Set<Reservation> reservation;
}
