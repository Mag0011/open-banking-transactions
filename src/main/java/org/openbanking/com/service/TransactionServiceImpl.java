package org.openbanking.com.service;

import org.openbanking.com.model.dto.TransactionDto;
import org.openbanking.com.persistence.TransactionRepository;
import org.openbanking.com.service.mapper.TransactionToDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    TransactionToDtoMapper transactionMapper;

    @Autowired
    TransactionRepository transactionRepository;

    @Transactional
    public List<TransactionDto> findAllByAccountNumber(Long accountNumber){
        return transactionRepository.findTransactionByAccountNumber(accountNumber)
                .stream()
                .map(transaction -> transactionMapper.transactionToTransactionDto(transaction))
                .collect(Collectors.toList());
    }

}
