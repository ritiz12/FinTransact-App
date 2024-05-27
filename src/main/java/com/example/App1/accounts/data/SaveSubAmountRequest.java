package com.example.App1.accounts.data;

import java.math.BigDecimal;

public class SaveSubAmountRequest {

    final private Long accountNumber ;
    final private BigDecimal amount; ;

    public SaveSubAmountRequest(Long accountNumber, BigDecimal amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
