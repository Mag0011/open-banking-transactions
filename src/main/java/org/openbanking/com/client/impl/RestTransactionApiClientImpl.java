package org.openbanking.com.client.impl;

import org.openbanking.com.client.RestTransactionApiClient;
import org.openbanking.com.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestTransactionApiClientImpl implements RestTransactionApiClient {

    @Override
    public List<Transaction> findTransactionByAccountNumber(Long accountNumber) {
        return List.of();
    }
    
}
