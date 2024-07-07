package org.openbanking.com.service;

import org.openbanking.com.model.dto.TransactionDto;
import org.openbanking.com.service.mapper.TransactionToDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    TransactionToDtoMapper transactionMapper;

    public List<TransactionDto> findAllByAccountNumber(String accountNumber){
        return List.of(TransactionDto.builder()
                .accountNumber(12345678)
                .type("Standard")
                .date(LocalDate.now())
                .amount(BigDecimal.valueOf(150000L))
                .currency("USD")
                .merchantLogo("Test_Logo")
                .merchantName("Test_Name").build());
    }

}
