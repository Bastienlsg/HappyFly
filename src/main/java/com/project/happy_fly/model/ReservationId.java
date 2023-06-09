package com.project.happy_fly.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
class ReservationId implements Serializable {
    @Column(name="user_handle")
    private String userHandle;

    @Column(name="circuit_name")
    private String circuitName;
}