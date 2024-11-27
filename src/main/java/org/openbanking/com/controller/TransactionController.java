package org.openbanking.com.controller;

import org.openbanking.com.model.dto.TransactionDto;
import org.openbanking.com.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions/{accountNumber}")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @GetMapping
    public List<TransactionDto> getTransactionService(@PathVariable Long accountNumber) {
        return transactionService.findAllByAccountNumber(accountNumber);
    }

}
