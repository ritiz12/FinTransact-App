package com.example.App1.accounts.api;


import com.example.App1.accounts.core.AmountService;
import com.example.App1.accounts.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AmountController {

    @Autowired
    AmountService amountService ;

    @PutMapping("/{accountNumber}/creditMoney")
    ResponseEntity<String> addMoneyInAccount(@PathVariable Long  accountNumber , @RequestBody SaveAddAmountRequest request)
    {
        final var response = amountService.addMoneyInAccount(accountNumber , request);
        return ResponseEntity.ok(response);

    }

    @PutMapping("/{accountNumber}/debitMoney")
    ResponseEntity<String> subMoneyFromAccount(@PathVariable Long accountNumber , @RequestBody SaveSubAmountRequest request)
    {
        final var response = amountService.subMoneyFromAccount(accountNumber , request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{accountNumber}/checkBalance")
    ResponseEntity<GetCheckBalanceResponse> checkAccountBalance(@PathVariable Long accountNumber )
    {
        final var response = amountService.checkAccountBalance(accountNumber );
        return  ResponseEntity.ok(response);
    }

     @PostMapping("/{accountNumber}/transferMoney")
    ResponseEntity<SaveTransferAmountResponse> transferMoney(@PathVariable Long  accountNumber , @RequestBody SaveTransferAmountRequest request)
     {
         final var response = amountService.addTransferMoney(accountNumber , request);
         return ResponseEntity.ok(response);
     }

     @GetMapping("/transactionHistory/{accountNumber}")
    ResponseEntity<GetTransactionHistoryResponse> getTransactionHistory(@PathVariable Long accountNumber)
     {
         final var response = amountService.getTransactionHistory(accountNumber);
         return ResponseEntity.ok(response);
     }

    @GetMapping("/recentTransactionHistory/{accountNumber}")
    ResponseEntity<GetTransactionHistoryResponse> getRecentTransactionHistory(@PathVariable Long accountNumber)
    {
        final var response = amountService.getTransactionHistory(accountNumber);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/dateWiseTransaction/{accountNumber}")
    ResponseEntity<GetTransactionHistoryResponse> getDateWiseTransaction(@PathVariable Long accountNumber, @RequestBody GetDateWiseTransactionHistoryRequest request)
    {
        final var response = amountService.getDateWiseTransaction(accountNumber , request);
        return ResponseEntity.ok(response);
    }





}
