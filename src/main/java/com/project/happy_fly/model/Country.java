package com.project.happy_fly.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank(message = "Le pays ne peut pas être vide")
    private String name;

    @OneToMany(mappedBy="country", cascade=CascadeType.ALL, orphanRemoval=true)
    private Set<City> cities;
}