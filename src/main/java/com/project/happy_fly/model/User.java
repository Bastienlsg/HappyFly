package com.project.happy_fly.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user")
public class User {
    @Id
    @Column(name="user_handle", length=50, nullable=false)
    @NotBlank(message = "Le pseudo ne peut pas être vide")
    private String handle;

    @Column(length=100)
    private String name;

    @Column(name="first_name", length=100)
    private String firstName;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="birth_date")
    private LocalDate birthDate;

    @Column(length=320, nullable=false)
    @NotBlank(message = "L'email ne peut pas être vide")
    @Email(message = "Le champ doit avoir une adresse mail valide")
    private String email;

    @Column(nullable=false)
    @NotBlank(message = "Le mot de passe ne peut pas être vide")
    @Size(min = 10, message = "Le mot de passe doit avoir au moins 10 caractères")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$", message = "Le mot de passe doit contenir au " +
            "moins une minuscule, une majuscule et un caractère spécial")
    private String password;

    @Column(name="is_admin", columnDefinition="bit(1) default 0")
    private boolean admin;

    @OneToMany(mappedBy="user", cascade=CascadeType.ALL, orphanRemoval=true)
    private Set<Reservation> reservation;
}