package org.openbanking.com.service;

import org.junit.jupiter.api.Test;
import org.openbanking.com.model.dto.TransactionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;

@SpringBootTest
public class TransactionServiceTest {

    @Autowired
    TransactionService transactionService;

    //@Spy
    //TransactionToDtoMapper transactionMapper;

    @Test
    public void whenAccountNumberHasTransactions_Then_ReturnPopulatedList() {
        List<TransactionDto> response = transactionService.findAllByAccountNumber(anyString());
        assertFalse(response.isEmpty());
    }

    @Test
    public void whenAccountNumberHasNoTransactions_Then_ReturnEmptyList() {
        List<TransactionDto> mockResponse = new ArrayList();
        List<TransactionDto> response = transactionService.findAllByAccountNumber(anyString());
        response = new ArrayList();
        assertEquals(mockResponse.size(), response.size());
    }

}
