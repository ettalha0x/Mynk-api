package com.nanozillas.mynkapi.repository;

import com.nanozillas.mynkapi.Models.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TransactionsRepo extends JpaRepository<Transactions, Long> {
    Optional<Transactions> findByTransactionId(String transId);
}
