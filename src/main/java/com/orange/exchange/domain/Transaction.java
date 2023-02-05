package com.orange.exchange.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction {
    @Id
    private Long id;
    private String currencyCode;
    private Long exchangeRateId;
    private float receivedAmount;
    private float releasedAmount;
    private String consumer;
    private LocalDate dateTrans;
    private Long exchangeOfficeId;
}
