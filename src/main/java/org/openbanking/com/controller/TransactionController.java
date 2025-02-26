package org.openbanking.com.controller;

import org.openbanking.com.model.Transaction;
import org.openbanking.com.model.dto.TransactionDto;
import org.openbanking.com.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @GetMapping("/{accountNumber}")
    public List<TransactionDto> getTransactionsByAccount(@PathVariable Long accountNumber) {
        return transactionService.findAllByAccountNumber(accountNumber);
    }

    @GetMapping("/accounts/{accountId}/transactions")
    public List<TransactionDto> getExternalTransaction(@PathVariable Long accountId) {
        return transactionService.findExternalTransactionsByAccountId(accountId);
    }

}
