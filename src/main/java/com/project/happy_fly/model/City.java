package com.project.happy_fly.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude="country")
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
}
