package com.bank.transactionservice.controller;

import com.bank.transactionservice.service.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
@AllArgsConstructor
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    public ResponseEntity<String> transferMoney(@RequestParam Long fromId,
                                                @RequestParam Long toId,
                                                @RequestParam Double ammount) {
        transactionService.transferMoney(fromId, toId, ammount);
        return ResponseEntity.ok("Transferred " + ammount + " to " + toId);
    }
}
