package org.openbanking.com.service;

import org.junit.jupiter.api.Test;
import org.mockito.Spy;
import org.openbanking.com.model.dto.TransactionDto;
import org.openbanking.com.persistence.TransactionRepository;
import org.openbanking.com.service.mapper.TransactionToDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.openbanking.com.TestUtils.mockTransactionBuilder;

@SpringBootTest
public class TransactionServiceTest {

    @Autowired
    TransactionService transactionService;

    @Spy
    TransactionToDtoMapper transactionMapper;

    @MockBean
    TransactionRepository transactionRepository;

    @Test
    public void whenAccountNumberHasTransactions_Then_ReturnPopulatedList() {

        when(transactionRepository.findTransactionByAccountNumber(anyLong()))
                .thenReturn(List.of(mockTransactionBuilder().build()));
        List<TransactionDto> response = transactionService.findAllByAccountNumber(123456789L);
        assertFalse(response.isEmpty());
    }

    @Test
    public void whenAccountNumberHasNoTransactions_Then_ReturnEmptyList() {
        List<TransactionDto> mockResponse = new ArrayList();
        List<TransactionDto> response = transactionService.findAllByAccountNumber(1234566789L);
        assertEquals(mockResponse.size(), response.size());
    }

}
