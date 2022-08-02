package com.glady.user;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class UserTest {

    @Test
    void cantBuildUserWithoutFirstname(){
        assertThatThrownBy(()-> new User(
                1L,
                null,
                "lastname",
                LocalDate.of(1990, 2, 16),
                "address",
                "position",
                null))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Firstname can't be null or empty");
    }

    @Test
    void cantBuildUserWithoutLastname(){
        assertThatThrownBy(()-> new User(
                1L,
                "firstname",
                null,
                LocalDate.of(1990, 2, 16),
                "address",
                "position",
                null))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Lastname can't be null or empty");
    }

    @Test
    void cantBuildUserWithDateOfBirthNotYeted(){
        LocalDate now = LocalDate.now();
        LocalDate dateOfBirth = now.plusDays(10L);
        assertThatThrownBy(()-> new User(
                1L,
                "firstname",
                "lastname",
                dateOfBirth,
                "address",
                "position",
                null))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("DateOfBirth can't be after datetime");
    }

}