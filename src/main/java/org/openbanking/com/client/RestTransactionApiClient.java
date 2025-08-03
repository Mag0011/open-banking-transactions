package org.openbanking.com.client;

import org.openbanking.com.model.Transaction;
import java.util.List;

public interface RestTransactionApiClient {

    List<Transaction> findTransactionByAccountNumber(Long accountNumber);

}