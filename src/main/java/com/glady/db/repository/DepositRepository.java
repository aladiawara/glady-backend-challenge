package com.glady.db.repository;

import com.glady.db.entity.Deposit;
import com.glady.db.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepositRepository extends JpaRepository<Deposit, Long> {
    List<Deposit> findAllByUser(User user);
}
