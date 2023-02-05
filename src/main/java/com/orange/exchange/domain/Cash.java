package com.orange.exchange.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cash {
    @Id
    private Long id;
    private String consumer;
    private String currencyCode;
    private float amount;
    private LocalDate date;
    private Long exchangeOfficeId;
}
