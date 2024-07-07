package org.openbanking.com.service;

import org.openbanking.com.model.dto.TransactionDto;

import java.util.List;

public interface TransactionService {

    List<TransactionDto> findAllByAccountNumber(String accountNumber);

}
