package org.openbanking.com.model.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@Data
public class TransactionDto {

    private String type;

    private LocalDate date;

    private long accountNumber;

    private String currency;

    private BigDecimal amount;

    private String merchantName;

    private String merchantLogo;

}
