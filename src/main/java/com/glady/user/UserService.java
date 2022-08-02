package com.glady.user;

import com.glady.db.entity.Deposit;
import com.glady.db.entity.Transaction;
import com.glady.db.repository.DepositRepository;
import com.glady.db.repository.TransactionRepository;
import com.glady.db.repository.UserRepository;
import com.glady.deposit.Type;
import com.glady.exception.BadRequest;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@Service
public record UserService(UserRepository userRepository, DepositRepository depositRepository, TransactionRepository transactionRepository) {
    private static final UserAdapter USER_ADAPTER = new UserAdapter();
    public User findUserById(Long id){
        com.glady.db.entity.User user = userRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("user with id %s not found", id))
        );

        return USER_ADAPTER.apply(user);
    }
    public List<User> findAllUsers(){
        return userRepository.findAll().stream().map(USER_ADAPTER).toList();
    }

    public double userBalance(@NonNull Long id, @NonNull String type){
        com.glady.db.entity.User user = userRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("user with id %s not found", id))
        );
        if (!Type.GIFT.getLibelle().equalsIgnoreCase(type) && !Type.MEAL.getLibelle().equalsIgnoreCase(type)){
            throw new BadRequest("type will be Gift or Meal");
        }
        double depositBalanceUser = depositBalanceUser(user, type);
        double totalTransactionsUser = totalTransactionsUser(user, type);
        return depositBalanceUser - totalTransactionsUser;
    }
    public double depositBalanceUser(@NonNull com.glady.db.entity.User user, @NonNull String type){
        return depositRepository.findAllByUser(user)
                .stream()
                .filter(t->type.equalsIgnoreCase(t.getType()))
                .filter(d->d.getEndDate().isAfter(LocalDateTime.now()))
                .mapToDouble(Deposit::getAmount)
                .sum();
    }

    public double totalTransactionsUser(@NonNull com.glady.db.entity.User user, @NonNull String type){
        return transactionRepository.findAllByUser(user)
                .stream()
                .filter(t->type.equalsIgnoreCase(t.getTransactionType()))
                .mapToDouble(Transaction::getAmount)
                .sum();
    }
}
