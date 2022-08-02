package com.glady.db.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Deposit {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private double amount;
    private String type;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    @ManyToOne
    private User user;

    public Deposit() {
    }

    public Deposit(double amount, String type, LocalDateTime startDate, LocalDateTime endDate, User user) {
        this.amount = amount;
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
