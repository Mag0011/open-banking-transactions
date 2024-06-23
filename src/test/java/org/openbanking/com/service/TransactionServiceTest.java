package org.openbanking.com.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;

@SpringBootTest
public class TransactionServiceTest {

    @Autowired
    TransactionService transactionService;

    @Test
    public void whenGettingTransactions_Then_ReturnList() {
        List mockResponse = Collections.emptyList();
        List response = transactionService.findAllByAccountNumber(anyString());
        assertEquals(mockResponse.size(), response.size());
    }

}
