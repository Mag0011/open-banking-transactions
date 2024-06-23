package org.openbanking.com.service;

import java.util.List;

public interface TransactionService {

    List findAllByAccountNumber(String accountNumber);

}
