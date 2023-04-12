package com.project.happy_fly.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="visit_place")
public class VisitPlace {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="place_id")
    private int id;

    @Column(length=100, nullable=false)
    private String label;

    @Column(nullable=false, columnDefinition="text")
    private String description;

    @Column(name="visit_cost", length=20, nullable=false)
    private String visitCost;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="city_id")
    private City cityId;

    @OneToMany(mappedBy="visitPlace", fetch = FetchType.LAZY)
    private Set<Media> medias;
}
