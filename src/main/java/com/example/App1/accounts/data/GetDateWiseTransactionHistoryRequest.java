package com.example.App1.accounts.data;

import java.util.Date;

public class GetDateWiseTransactionHistoryRequest {
     private Date date ;
    public GetDateWiseTransactionHistoryRequest() {

    }
    public GetDateWiseTransactionHistoryRequest(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }
}
