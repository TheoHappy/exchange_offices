package com.orange.exchange.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder
public class TransactionRequestDto {
    private String currencyCode;
    private float receivedAmount;
    private String consumer;
    private LocalDate dateTrans;
    private Long exchangeOfficeId;
}
