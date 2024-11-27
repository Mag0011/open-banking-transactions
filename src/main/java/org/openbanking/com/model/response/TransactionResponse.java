package org.openbanking.com.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TransactionResponse {

    private String type;

    private LocalDate date;

    private long accountNumber;

    private String currency;

    private BigDecimal amount;

    private String merchantName;

    private String merchantLogo;

}
