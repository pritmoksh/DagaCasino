package com.dagacube.casino.repository;

import com.dagacube.casino.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    Boolean existsByTransactionId(Long transactionId);
}
