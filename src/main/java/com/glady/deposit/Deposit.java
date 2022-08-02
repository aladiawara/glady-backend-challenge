package com.glady.deposit;

import com.glady.user.User;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;

public record Deposit(double amount, LocalDateTime startDate, LocalDateTime endDate, User user) {
    public Deposit {
        if (ObjectUtils.isEmpty(user)) {
            throw new IllegalArgumentException("User must be present for deposit");
        }
    }
}
