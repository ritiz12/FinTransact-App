package com.example.App1.accounts.data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class SaveTransferAmountResponse {
    Collection<SaveTransferAmountSummary> transferAmountData ;

    public void addTransferAmountData(SaveTransferAmountSummary data)
    {
        if(transferAmountData == null)
        {
            transferAmountData = new ArrayList<>();
        }
        transferAmountData.add(data);
    }

    public Collection<SaveTransferAmountSummary> getTransferAmountData() {
        return transferAmountData;
    }
}
