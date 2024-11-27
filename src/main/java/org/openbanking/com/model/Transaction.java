package org.openbanking.com.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "transactions")
public class Transaction {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type", nullable = false, length = 100)
    private String type;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "account_number", length = 18)
    private long accountNumber;

    @Column(name = "currency",  length = 5)
    private String currency;

    @Column(name = "amount", length = 10)
    private BigDecimal amount;

    @Column(name = "merchant_name",  length = 100)
    private String merchantName;

    @Column(name = "merchant_logo", length = 255)
    private String merchantLogo;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
