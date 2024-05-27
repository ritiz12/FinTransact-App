package com.example.App1.accounts.persistence;

import com.example.App1.accounts.domain.TransactionHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionHistoryRepository extends JpaRepository<TransactionHistory,Long> {

    List<TransactionHistory> findByAccountNumber(Long accountNumber);
}
