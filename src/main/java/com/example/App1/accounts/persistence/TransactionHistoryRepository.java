package com.example.App1.accounts.persistence;

import com.example.App1.accounts.domain.TransactionHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TransactionHistoryRepository extends JpaRepository<TransactionHistory,Long> {

    List<TransactionHistory> findByAccountNumber(Long accountNumber);


    @Query("SELECT t FROM TransactionHistory t WHERE t.accountNumber = :accountNumber AND DATE(t.transactionDate) = DATE(:transactionDate)")
    List<TransactionHistory> findByAccountNumberTransactionDate(@Param("accountNumber") Long accountNumber, @Param("transactionDate") Date transactionDate);
}
