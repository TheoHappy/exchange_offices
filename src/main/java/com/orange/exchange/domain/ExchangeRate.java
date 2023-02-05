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
public class ExchangeRate {
    @Id
    private Long id;
    private String currencyCode;
    private float rate;
    private float course;
    private LocalDate dateCurs;
    private Long exchangeOfficeId;
}