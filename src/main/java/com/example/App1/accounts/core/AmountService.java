package com.example.App1.accounts.core;

import com.example.App1.accounts.data.SaveAddAmountRequest;
import com.example.App1.accounts.data.SaveAddAmountResponse;
import com.example.App1.accounts.domain.Account;
import com.example.App1.accounts.persistence.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Objects;

@Service
public class AmountService {

    @Autowired
    AccountRepository accountRepository ;
    public String addMoneyInAccount(Long accountNumber, final SaveAddAmountRequest request) {
        Account account = accountRepository.findByAccountNumber(accountNumber);
        System.out.println(account);
        if (account == null) {
            throw new RuntimeException("Account Not Found");
        }
        var response = "";
        BigDecimal totalBalance = account.getAccountBalance().add(request.getAmount());
        account.setAccountBalance(totalBalance);
        accountRepository.save(account);
        if (Objects.equals(account.getAccountBalance(), totalBalance)) {
            response = "Money Add SuccessFully";
        }
         return response;

    }
}
