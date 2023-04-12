package com.project.happy_fly.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="reservation")
public class Reservation {
    @EmbeddedId
    private ReservationId id;

    @ManyToOne
    @MapsId("userHandle")
    @JoinColumn(name="user_handle")
    private User user;

    @ManyToOne
    @MapsId("circuitName")
    @JoinColumn(name="circuit_name")
    private Circuit circuit;

    @Column(name="nbr_places", nullable=false)
    private int nbrPlaces;

    @Column(name="reservation_date", nullable=false)
    private LocalDateTime reservationDate;

    @PrePersist
    public void prePersist() {
        reservationDate = LocalDateTime.now();
    }
}