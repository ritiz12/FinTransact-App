package com.example.App1.userDetails.data;

import java.math.BigDecimal;
import java.util.Date;

public class GetUserInformationRequest {
    final private Long accountNumber ;

    public GetUserInformationRequest(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }
}
