package com.glady.db.repository;

import com.glady.db.entity.Transaction;
import com.glady.db.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findAllByUser(User user);
}
