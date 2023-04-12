package com.project.happy_fly.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="stage")
public class Stage {
    @EmbeddedId
    private StageId id;

    @ManyToOne
    @MapsId("placeId")
    @JoinColumn(name="place_id")
    private VisitPlace visitPlace;

    @ManyToOne
    @MapsId("circuitName")
    @JoinColumn(name="circuit_name")
    private Circuit circuit;

    @Temporal(TemporalType.DATE)
    @Column(name="stage_date", nullable=false)
    private Date stageDate;

    @Column(name="duration_minute", nullable=false)
    private int durationMinute;

    @Column(name="stage_order", nullable=false)
    private int stageOrder;
}
