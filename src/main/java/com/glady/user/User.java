package com.glady.user;

import com.glady.compagny.Company;
import org.springframework.util.StringUtils;

import java.time.LocalDate;

public record User(Long id, String firstname, String lastname, LocalDate dateOfBirth, String address, String position, String company) {

    public User {
        notNullOrEmptyFirstName(firstname);
        notNullOrEmptyLastName(lastname);
        dateOfBirthNotYeted(dateOfBirth);
    }

    private void notNullOrEmptyFirstName(String firstname){
        if (!StringUtils.hasText(firstname)) {
            throw new IllegalArgumentException("Firstname can't be null or empty");
        }
    }

    private void notNullOrEmptyLastName(String lastname){
        if (!StringUtils.hasText(lastname)) {
            throw new IllegalArgumentException("Lastname can't be null or empty");
        }
    }

    private void dateOfBirthNotYeted(LocalDate dateOfBirth){
        if (dateOfBirth != null && dateOfBirth.isAfter(LocalDate.now())){
            throw new IllegalArgumentException("DateOfBirth can't be after datetime");
        }
    }
}
