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
class StageId implements Serializable {
    @Column(name="place_id")
    private int placeId;

    @Column(name="circuit_name")
    private String circuitName;
}