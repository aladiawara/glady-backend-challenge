package com.glady.deposit;

import com.glady.constant.Constant;
import com.glady.db.entity.Compagny;
import com.glady.db.entity.User;
import com.glady.db.repository.DepositRepository;
import com.glady.db.repository.UserRepository;
import com.glady.exception.BadRequest;
import com.glady.exception.NotFound;
import com.glady.user.UserAdapter;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


@Service
public record DepositService(DepositRepository depositRepository, UserRepository userRepository) {
    private static final UserAdapter USER_ADAPTER = new UserAdapter();

    public Deposit addGift(Deposit deposit) {
        User user = verifyDeposit(deposit);
        LocalDateTime startDate = LocalDateTime.now();
        LocalDateTime endDate = startDate.plusDays(Constant.GIFT_DAYS_LIFESPAN);
        com.glady.db.entity.Deposit userDeposit = new com.glady.db.entity.Deposit(
            deposit.amount(), Type.GIFT.getLibelle(), startDate, endDate, user
        );
        userDeposit = depositRepository.save(userDeposit);
        return new Deposit(userDeposit.getAmount(), userDeposit.getStartDate(), userDeposit.getEndDate(), USER_ADAPTER.apply(user));
    }

    public Deposit addMeal(Deposit deposit) {
        User user = verifyDeposit(deposit);
        LocalDateTime startDate = LocalDateTime.now();
        int nexYear = startDate.getYear() + 1;
        LocalDate dateNextYear = LocalDate.of(nexYear, 3, 1);
        LocalDateTime expirationDate = LocalDateTime.of(dateNextYear, LocalTime.MIN);
        com.glady.db.entity.Deposit userDeposit = new com.glady.db.entity.Deposit(
                deposit.amount(), Type.MEAL.getLibelle(), startDate, expirationDate, user
        );
        userDeposit = depositRepository.save(userDeposit);
        return new Deposit(userDeposit.getAmount(), userDeposit.getStartDate(), userDeposit.getEndDate(), USER_ADAPTER.apply(user));
    }

    private User verifyDeposit(Deposit deposit) {
        User user = userRepository.findById(deposit.user().id()).orElseThrow(
                () -> new NotFound(String.format("No user with id %s", deposit.user().id()))
        );
        Compagny compagny = user.getCompagny();
        if (compagny == null) {
            throw new BadRequest(String.format("No compagny for user %s", user));
        }
        if (compagny.getBalance() <= deposit.amount()){
            throw new BadRequest("Your balance does not allow you to perform this operation");
        }
        return user;
    }
}
