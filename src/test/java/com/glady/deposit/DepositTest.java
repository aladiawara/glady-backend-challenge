package com.glady.deposit;

import com.glady.constant.Constant;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class DepositTest {

    @Test
    void cantDoDepositWithoutUser(){
        LocalDateTime star = LocalDateTime.now();
        assertThatThrownBy(
                () ->  new Deposit(10.0, star,star.plusDays(Constant.GIFT_DAYS_LIFESPAN),null)
        ).isExactlyInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("User must be present for deposit");
    }

}