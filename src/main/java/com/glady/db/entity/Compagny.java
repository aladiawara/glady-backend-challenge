package com.glady.db.entity;

import javax.persistence.*;

@Entity
public class Compagny {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "compagny_name", unique = true)
    private String name;
    @Column (unique = true)
    private String siret;
    private String socialReason;
    private double balance;

    public Compagny(String name, String siret, String socialReason, double balance) {
        this.name = name;
        this.siret = siret;
        this.socialReason = socialReason;
        this.balance = balance;
    }

    public Compagny() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSiret() {
        return siret;
    }

    public void setSiret(String siret) {
        this.siret = siret;
    }

    public String getSocialReason() {
        return socialReason;
    }

    public void setSocialReason(String socialReason) {
        this.socialReason = socialReason;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
