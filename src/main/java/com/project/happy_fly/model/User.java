package com.project.happy_fly.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user")
public class User {
    @Id
    @Column(name="user_handle", length=50, nullable=false)
    private String handle;

    @Column(length=100)
    private String name;

    @Column(name="first_name", length=100)
    private String firstName;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="birth_date")
    private Date birthDate;

    @Column(length=320, nullable=false)
    private String email;

    @Column(nullable=false)
    private String password;

    @Column(name="is_admin", columnDefinition="bit(1) default 0")
    private boolean isAdmin;

    @OneToMany(mappedBy="user", cascade=CascadeType.ALL, orphanRemoval=true)
    private Set<Reservation> reservation;
}