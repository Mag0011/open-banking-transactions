package org.openbanking.com.model.request;

import org.openbanking.com.model.Transaction;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class OBTransactionMapper {

    public Transaction map(com.open_banking.model.OBReadDataTransaction6 obReadDataTransaction6) {
        com.open_banking.model.OBTransaction6 obTransaction6 = obReadDataTransaction6.getTransaction().get(0);
        return  Transaction.builder()
                .accountNumber(Long.parseLong(obTransaction6.getAccountId()))
                .type(obTransaction6.getCreditDebitIndicator().getValue())
                .currency(obTransaction6.getCurrencyExchange().getUnitCurrency())
                .amount(calculateAmountFromOBTransaction6(obTransaction6))
                .merchantName(obTransaction6.getMerchantDetails().getMerchantName())
                .date(obTransaction6.getValueDateTime().toLocalDate())
                .build();
    }

    private BigDecimal calculateAmountFromOBTransaction6(com.open_banking.model.OBTransaction6 obTransaction6) {
        long obTransaction6Amount = Long.parseLong(obTransaction6.getAmount().getAmount());
        BigDecimal obTransaction6ExchangeRatee = obTransaction6.getCurrencyExchange().getExchangeRate();
        return BigDecimal.valueOf(obTransaction6Amount).multiply(obTransaction6ExchangeRatee);
    }

}