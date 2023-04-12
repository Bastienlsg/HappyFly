package com.project.happy_fly.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="circuit")
public class Circuit {
    @Id
    @Column(name="circuit_name", length=100, nullable=false)
    private String name;

    @Column(nullable=false, columnDefinition="text")
    private String description;

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

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="departure_city")
    private City departureCity;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="arrival_city")
    private City arrivalCity;

    @OneToOne(mappedBy = "circuit", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Media media;

    @OneToMany(mappedBy="circuit", cascade=CascadeType.ALL, orphanRemoval=true)
    private Set<Reservation> reservations;
}