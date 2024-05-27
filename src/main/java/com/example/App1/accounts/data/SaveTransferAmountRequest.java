package com.example.App1.accounts.data;

import java.math.BigDecimal;
import java.util.Date;

public class SaveTransferAmountRequest {
    final private Long accountNumber;
    final private Long toAccountNumber;
    final  private BigDecimal transferAmount;

    public SaveTransferAmountRequest(Long accountNumber, Long toAccountNumber, BigDecimal transferAmount) {
        this.accountNumber = accountNumber;
        this.toAccountNumber = toAccountNumber;
        this.transferAmount = transferAmount;
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
}
