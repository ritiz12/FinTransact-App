package com.example.App1.accounts.data;

import java.math.BigDecimal;
import java.util.Date;

public class SaveAddAmountRequest {
    final private Long accountNumber ;
    final private BigDecimal amount; ;

    public SaveAddAmountRequest(Long accountNumber, BigDecimal amount) {
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
