package com.orange.exchange.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder
public class ExchangeRateDto {
    private String currencyCode;
    private float rate;
    private float course;
    private LocalDate dateCurs;
    private Long exchangeOfficeId;
}
