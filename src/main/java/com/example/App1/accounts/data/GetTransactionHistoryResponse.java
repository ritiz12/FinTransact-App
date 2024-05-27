package com.example.App1.accounts.data;

import java.util.ArrayList;
import java.util.Collection;

public class GetTransactionHistoryResponse {
    Collection<GetTransactionHistorySummary> transactionHistoryRecord ;

    public void addTransactionHistoryRecord(GetTransactionHistorySummary data)
    {
        if(transactionHistoryRecord == null)
        {
            transactionHistoryRecord = new ArrayList<>();
        }
        transactionHistoryRecord.add(data);
    }

    public Collection<GetTransactionHistorySummary> getTransactionHistoryRecord() {
        return transactionHistoryRecord;
    }
}
