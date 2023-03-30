package com.project.happy_fly.model;

import jakarta.persistence.*;

@Entity
@Table(name="reservation")
public class Reservation {
    @EmbeddedId
    ReservationId id;

    @ManyToOne
    @MapsId("userHandle")
    @JoinColumn(name="user_handle")
    User user;

    @ManyToOne
    @MapsId("circuitName")
    @JoinColumn(name="circuit_name")
    Circuit circuit;
}