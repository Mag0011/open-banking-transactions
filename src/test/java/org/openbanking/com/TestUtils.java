package org.openbanking.com;

import org.openbanking.com.model.Transaction;
import org.openbanking.com.model.dto.TransactionDto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;

public class TestUtils {

    public static Transaction.TransactionBuilder mockTransactionBuilder() {
        return Transaction.builder()
                .accountNumber(12345678)
                .type("Standard")
                .date(LocalDate.now())
                .amount(BigDecimal.valueOf(150000L))
                .currency("USD")
                .merchantLogo("Test_Logo")
                .merchantName("Test_Name");
    }

    public static TransactionDto.TransactionDtoBuilder mockTransactionDtoBuilder() {
        return TransactionDto.builder()
                .accountNumber(12345678)
                .type("Standard")
                .date(LocalDate.now())
                .amount(BigDecimal.valueOf(150000L))
                .currency("USD")
                .merchantLogo("Test_Logo")
                .merchantName("Test_Name");
    }

    public static com.open_banking.model.OBReadDataTransaction6 mockOBReadDataTransaction6(List<com.open_banking.model.OBTransaction6> transaction6List) {
        com.open_banking.model.OBReadDataTransaction6 obReadDataTransaction6 =
                new com.open_banking.model.OBReadDataTransaction6();
        obReadDataTransaction6.setTransaction(transaction6List);
        return obReadDataTransaction6;
    }

    public static com.open_banking.model.OBTransaction6 mockOBTransaction6(String accountId, String creditType,
                                                                           String unitCurrency, String amount,
                                                                           String merchantName,
                                                                           OffsetDateTime dateTime) {
        com.open_banking.model.OBTransaction6 obTransaction6 = new com.open_banking.model.OBTransaction6();
        obTransaction6.setAccountId(accountId);
        obTransaction6.setCreditDebitIndicator(com.open_banking.model.OBCreditDebitCode1.valueOf(creditType));
        obTransaction6.setCurrencyExchange(mockOBCurrencyExchange5(unitCurrency));
        obTransaction6.setAmount(obActiveOrHistoricCurrencyAndAmount9(amount));
        obTransaction6.setMerchantDetails(obMerchantDetails1(merchantName));
        obTransaction6.setValueDateTime(dateTime);
        return obTransaction6;
    }

    public static com.open_banking.model.OBCurrencyExchange5 mockOBCurrencyExchange5(String unitCurrency) {
        com.open_banking.model.OBCurrencyExchange5 obCurrencyExchange5 =
                new com.open_banking.model.OBCurrencyExchange5();
        obCurrencyExchange5.setUnitCurrency(unitCurrency);
        return obCurrencyExchange5;
    }

    public static com.open_banking.model.OBActiveOrHistoricCurrencyAndAmount9 obActiveOrHistoricCurrencyAndAmount9(
            String amount) {
        com.open_banking.model.OBActiveOrHistoricCurrencyAndAmount9 obActiveOrHistoricCurrencyAndAmount9 =
                new com.open_banking.model.OBActiveOrHistoricCurrencyAndAmount9();
        obActiveOrHistoricCurrencyAndAmount9.setAmount(amount);
        return obActiveOrHistoricCurrencyAndAmount9;
    }

    public static com.open_banking.model.OBMerchantDetails1 obMerchantDetails1(String merchantName) {
        com.open_banking.model.OBMerchantDetails1 obMerchantDetails1 = new com.open_banking.model.OBMerchantDetails1();
        obMerchantDetails1.setMerchantName(merchantName);
        return obMerchantDetails1;
    }

}