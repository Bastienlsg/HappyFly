package com.project.happy_fly.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="user")
public class User {
    @Id
    @Basic
    @Column(name="handle", length=50, nullable=false)
    private String handle;

    @Basic
    @Column(name="name", length=100, nullable=false)
    private String name;

    @Basic
    @Column(name="first_name", length=100, nullable=false)
    private String firstName;

    @Temporal(TemporalType.DATE)
    @Column(name="birth_date", nullable=false)
    private Date birthDate;

    @Basic
    @Column(name="email", length=320, nullable=false)
    private String email;

    @Basic
    @Column(name="password", length=250, nullable=false)
    private String password;

    @Basic
    @Column(name="is_admin", columnDefinition = "bit(1) default 0")
    private boolean isAdmin = false;

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
