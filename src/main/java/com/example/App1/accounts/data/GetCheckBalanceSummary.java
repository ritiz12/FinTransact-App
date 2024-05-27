package com.example.App1.accounts.data;

import java.math.BigDecimal;

public class GetCheckBalanceSummary {
    final private Long accountNumber ;
    final private BigDecimal accountBalance ;

    public GetCheckBalanceSummary(Long accountNumber, BigDecimal accountBalance) {
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }
}
