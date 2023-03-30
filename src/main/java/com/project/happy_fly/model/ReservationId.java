package com.project.happy_fly.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
class ReservationId implements Serializable {

    @Column(name="user_handle")
    String userHandle;

    @Column(name="circuit_name")
    String circuitName;
}