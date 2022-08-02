package com.glady.db.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "_users")
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    private LocalDate dateOfBirth;
    private String address;
    private String position;
    @ManyToOne (fetch = FetchType.EAGER)
    private Compagny compagny;

    public User() {
    }

    public User(String firstname, String lastname, LocalDate dateOfBirth, String address, String position, Compagny compagny) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.position = position;
        this.compagny = compagny;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Compagny getCompagny() {
        return compagny;
    }

    public void setCompagny(Compagny compagny) {
        this.compagny = compagny;
    }
}
