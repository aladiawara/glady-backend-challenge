package com.glady.deposit;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("deposit")
public record DepositResource(DepositService depositService) {

    @PostMapping("meal")
    Deposit addMeal(@RequestBody Deposit deposit){
        return depositService.addMeal(deposit);
    }

    @PostMapping("gift")
    Deposit addGift(@RequestBody Deposit deposit){
        return depositService.addGift(deposit);
    }

}
