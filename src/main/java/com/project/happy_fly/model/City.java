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
@Table(name="city")
public class City {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="city_id")
    private int id;

    @Column(length=100, nullable=false)
    private String name;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="country_name")
    private Country country;

    @OneToMany(mappedBy="departureCity", fetch=FetchType.LAZY)
    private Set<Circuit> departureCity;

    @OneToMany(mappedBy="arrivalCity", fetch=FetchType.LAZY)
    private Set<Circuit> arrivalCity;
}
