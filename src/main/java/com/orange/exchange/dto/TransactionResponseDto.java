package com.orange.exchange.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder
public class TransactionResponseDto {
    private String currencyCode;
    private float exchangeRate;
    private float receivedAmount;
    private float releasedAmount;
    private String consumer;
    private LocalDate dateTrans;
    private Long exchangeOfficeId;
}
