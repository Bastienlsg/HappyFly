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
@Table(name="country")
public class Country {
    @Id
    @Column(length=100, nullable=false)
    private String name;

    @OneToMany(mappedBy="name", cascade=CascadeType.ALL, orphanRemoval=true)
    private Set<City> cities;

    @OneToMany(mappedBy="country", fetch=FetchType.LAZY)
    private Set<City> country;
}