package com.example.App1.accounts.api;


import com.example.App1.accounts.core.AmountService;
import com.example.App1.accounts.data.SaveAddAmountRequest;
import com.example.App1.accounts.data.SaveAddAmountResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
public class AmountController {

    @Autowired
    AmountService amountService ;

    @PutMapping("/{accountNumber}/addMoney")
    ResponseEntity<String> addMoneyInAccount(@PathVariable Long  accountNumber , @RequestBody SaveAddAmountRequest request)
    {
        final var response = amountService.addMoneyInAccount(accountNumber , request);
        return ResponseEntity.ok(response);

    }

}
