package com.example.App1.accounts.data;

import java.math.BigDecimal;
import java.util.Date;

public class SaveTransferAmountSummary {
    final private Long accountNumber;
    final private Long toAccountNumber;
    final  private BigDecimal transferAmount;

    final  private Long TransactionId ;

    final private Date transactionDate;

    final private String transactionStatus;

    public SaveTransferAmountSummary(Long accountNumber, Long toAccountNumber, BigDecimal transferAmount, Long transactionId, Date transactionDate, String transactionStatus) {
        this.accountNumber = accountNumber;
        this.toAccountNumber = toAccountNumber;
        this.transferAmount = transferAmount;
        TransactionId = transactionId;
        this.transactionDate = transactionDate;
        this.transactionStatus = transactionStatus;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public Long getToAccountNumber() {
        return toAccountNumber;
    }

    public BigDecimal getTransferAmount() {
        return transferAmount;
    }

    public Long getTransactionId() {
        return TransactionId;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public String getTransactionStatus() {
        return transactionStatus;
    }
}
