package org.openbanking.com.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@Data
public class Transaction {

    private String type;

    private LocalDate date;

    private long accountNumber;

    private BigDecimal currency;

    private BigDecimal amount;

    private String merchantName;

    private String merchantLogo;

}
