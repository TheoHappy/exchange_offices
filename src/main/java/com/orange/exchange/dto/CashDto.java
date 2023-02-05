package com.orange.exchange.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder
public class CashDto {
    private String consumer;
    private String currencyCode;
    private float amount;
    private LocalDate date;
    private Long exchangeOfficeId;
}
