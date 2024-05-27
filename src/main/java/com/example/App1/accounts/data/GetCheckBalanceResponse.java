package com.example.App1.accounts.data;

import java.util.ArrayList;
import java.util.Collection;

public class GetCheckBalanceResponse {

    Collection<GetCheckBalanceSummary> balanceRecord ;

    public void addBalance(GetCheckBalanceSummary data)
    {
        if(balanceRecord == null)
        {
            balanceRecord = new ArrayList<>();
        }
        balanceRecord.add(data);
    }

    public Collection<GetCheckBalanceSummary> getBalanceRecord() {
        return balanceRecord;
    }
}
