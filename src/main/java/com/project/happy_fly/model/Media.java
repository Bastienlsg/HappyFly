package com.project.happy_fly.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="media")
public class Media {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="media_id")
    private int id;

    @Column(length=250, nullable=false)
    private String url;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="circuit_name")
    private Circuit circuit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "place_id")
    private VisitPlace visitPlace;
}