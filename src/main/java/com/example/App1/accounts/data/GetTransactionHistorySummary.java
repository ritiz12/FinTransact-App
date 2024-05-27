package com.example.App1.accounts.data;

import java.math.BigDecimal;
import java.util.Date;

public class GetTransactionHistorySummary {
    final private Long TransactionId ;

   final  private Long accountNumber;

    final private Long toAccountNumber;

   final  private Date transactionDate;

   final  private String transactionStatus;

   final  private BigDecimal transferAmount;

    public GetTransactionHistorySummary(Long transactionId, Long accountNumber, Long toAccountNumber, Date transactionDate, String transactionStatus, BigDecimal transferAmount) {
        TransactionId = transactionId;
        this.accountNumber = accountNumber;
        this.toAccountNumber = toAccountNumber;
        this.transactionDate = transactionDate;
        this.transactionStatus = transactionStatus;
        this.transferAmount = transferAmount;
    }

    public Long getTransactionId() {
        return TransactionId;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public Long getToAccountNumber() {
        return toAccountNumber;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public String getTransactionStatus() {
        return transactionStatus;
    }

    public BigDecimal getTransferAmount() {
        return transferAmount;
    }
}
