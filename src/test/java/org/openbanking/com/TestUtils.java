package org.openbanking.com;

import org.openbanking.com.model.Transaction;
import org.openbanking.com.model.dto.TransactionDto;

import java.math.BigDecimal;
import java.time.LocalDate;

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

}
