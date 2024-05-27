package com.example.App1.accounts.core;

import com.example.App1.accounts.data.*;
import com.example.App1.accounts.domain.Account;
import com.example.App1.accounts.domain.TransactionHistory;
import com.example.App1.accounts.persistence.AccountRepository;
import com.example.App1.accounts.persistence.TransactionHistoryRepository;
import com.example.App1.userDetails.data.GetUserInformationResponse;
import com.example.App1.userDetails.data.GetUserInformationSummary;
import com.example.App1.userDetails.domain.UserInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class AmountService {

    @Autowired
    AccountRepository accountRepository ;

    @Autowired
    TransactionHistoryRepository transactionHistoryRepository ;


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
            response = "Money Credit SuccessFully";
        }
         return response;

    }

    public String subMoneyFromAccount(Long accountNumber,final  SaveSubAmountRequest request) {
        Account account = accountRepository.findByAccountNumber(accountNumber);
        if(account == null)
        {
            throw new RuntimeException("Account Not Found");
        }
        var response = "";
        BigDecimal totalBalance = account.getAccountBalance().subtract(request.getAmount());
        account.setAccountBalance(totalBalance);
        accountRepository.save(account);
        if(Objects.equals(account.getAccountBalance() , totalBalance))
        {
            response = "Money Debit Successfully";
        }
        return response;
    }
    public GetCheckBalanceResponse checkAccountBalance(Long accountNumber) {

        Account account = accountRepository.findByAccountNumber(accountNumber);
        if(account == null)
        {
            throw new RuntimeException("Account Not Found");
        }

       BigDecimal accountBalance = account.getAccountBalance();
        GetCheckBalanceSummary summary = new GetCheckBalanceSummary(account.getAccountNumber(),account.getAccountBalance());
        GetCheckBalanceResponse response = new GetCheckBalanceResponse();
        response.addBalance(summary);
        return response;
    }


    public SaveTransferAmountResponse addTransferMoney(Long accountNumber, final SaveTransferAmountRequest request) {
       Long fromAccountNumber = request.getAccountNumber();
       Long toAccountNumber = request.getToAccountNumber();
       BigDecimal amount = request.getTransferAmount();
       System.out.println(amount);
       Account fromAccount = accountRepository.findByAccountNumber(fromAccountNumber);
       Account toAccount = accountRepository.findByAccountNumber(toAccountNumber);

       if(fromAccount == null)
       {
           throw  new RuntimeException("Source account not found");
       }

        if(toAccount == null)
        {
            throw  new RuntimeException("Destination account not found");
        }

        if (fromAccount.getAccountBalance().compareTo(amount) < 0) {
            throw new RuntimeException("Insufficient funds in the source account");
        }
        fromAccount.setAccountBalance(fromAccount.getAccountBalance().subtract(amount));
        toAccount.setAccountBalance(toAccount.getAccountBalance().add(amount));

        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);
        System.out.println(toAccount.getAccountBalance());
           Date currentDate = new Date();
        UserInformation userId = fromAccount.getUserInformation();
        TransactionHistory transactionHistory = new TransactionHistory( request.getAccountNumber() , request.getToAccountNumber(), currentDate,"Done",request.getTransferAmount(),userId);

        transactionHistoryRepository.save(transactionHistory);
           SaveTransferAmountSummary summary = new SaveTransferAmountSummary(transactionHistory.getAccountNumber(),transactionHistory.getToAccountNumber(),transactionHistory.getTransferAmount(),transactionHistory.getTransactionId(),transactionHistory.getTransactionDate(),transactionHistory.getTransactionStatus());
        var response = new SaveTransferAmountResponse();
        response.addTransferAmountData(summary);
        return response;

    }


    public GetTransactionHistoryResponse getTransactionHistory(Long accountNumber) {
        List<TransactionHistory> transactionHistories = transactionHistoryRepository.findByAccountNumber(accountNumber);

        GetTransactionHistoryResponse response = new GetTransactionHistoryResponse();

        for (TransactionHistory transactionHistory : transactionHistories) {
            GetTransactionHistorySummary summary = new GetTransactionHistorySummary(
                    transactionHistory.getTransactionId(),
                    transactionHistory.getAccountNumber(),
                    transactionHistory.getToAccountNumber(),
                    transactionHistory.getTransactionDate(),
                    transactionHistory.getTransactionStatus(),
                    transactionHistory.getTransferAmount()
            );
            response.addTransactionHistoryRecord(summary);
        }

        return response;
    }


    public GetTransactionHistoryResponse getRecentTransactionHistory(Long accountNumber) {
        List<TransactionHistory> transactionHistories = transactionHistoryRepository.findByAccountNumber(accountNumber);

        // Sort the transactionHistories by transaction date in descending order
        Collections.sort(transactionHistories, Comparator.comparing(TransactionHistory::getTransactionDate).reversed());

        // Get the last 4 transactions
        List<TransactionHistory> last4Transactions = transactionHistories.stream().limit(4).collect(Collectors.toList());

        GetTransactionHistoryResponse response = new GetTransactionHistoryResponse();

        for (TransactionHistory transactionHistory : last4Transactions) {
            GetTransactionHistorySummary summary = new GetTransactionHistorySummary(
                    transactionHistory.getTransactionId(),
                    transactionHistory.getAccountNumber(),
                    transactionHistory.getToAccountNumber(),
                    transactionHistory.getTransactionDate(),
                    transactionHistory.getTransactionStatus(),
                    transactionHistory.getTransferAmount()
            );
            response.addTransactionHistoryRecord(summary);
        }

        return response;
    }



}
