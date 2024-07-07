package org.openbanking.com.service.mapper;

import org.openbanking.com.model.Transaction;
import org.openbanking.com.model.dto.TransactionDto;
import org.springframework.stereotype.Component;

@Component
public class TransactionToDtoMapper {

    public TransactionDto transactionToTransactionDto(Transaction transaction) {
        return TransactionDto.builder()
                .type(transaction.getType())
                .date(transaction.getDate())
                .accountNumber(transaction.getAccountNumber())
                .currency(transaction.getCurrency())
                .amount(transaction.getAmount())
                .merchantLogo(transaction.getMerchantLogo())
                .merchantName(transaction.getMerchantName())
                .build();
    }

}
