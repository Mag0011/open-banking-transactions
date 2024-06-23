package org.openbanking.com.service;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService{

    public List findAllByAccountNumber(String accountNumber){
        return Collections.emptyList();
    }

}
