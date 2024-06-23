package org.openbanking.com.controller;

import org.openbanking.com.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transactions/{accountNumber}")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @GetMapping
    public List getTransactionService(@PathVariable(value = "accountNumber") String accountNumber) {
        return transactionService.findAllByAccountNumber(accountNumber);
    }
}
