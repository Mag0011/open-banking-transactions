package org.openbanking.com.model.adapter;

import org.openbanking.com.model.Transaction;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OBTransactionAdapter {

    public List<Transaction> mapper(com.open_banking.model.OBReadDataTransaction6 obReadDataTransaction6) {
        return obReadDataTransaction6.getTransaction().stream()
                .map(obTransaction6 -> Transaction.builder()
                        .accountNumber(Long.parseLong(obTransaction6.getAccountId()))
                        .type(obTransaction6.getCreditDebitIndicator().getValue())
                        .currency(obTransaction6.getCurrencyExchange().getUnitCurrency())
                        .amount(BigDecimal.valueOf(
                                Double.parseDouble(obTransaction6.getAmount().getAmount())
                        ))
                        .merchantName(obTransaction6.getMerchantDetails().getMerchantName())
                        .date(obTransaction6.getValueDateTime().toLocalDate())
                        .build())
                .collect(Collectors.toList());
    }

}
