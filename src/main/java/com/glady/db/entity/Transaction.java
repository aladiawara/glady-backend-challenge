package com.glady.db.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
public class Transaction {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private double amount;
    private LocalDateTime transactionDate;
    private String transactionType;
    @ManyToOne
    private User user;

    public Transaction(double amount, LocalDateTime transactionDate, String transactionType, User user) {
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.transactionType = transactionType;
        this.user = user;
    }

    public Transaction() {
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

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }
}
