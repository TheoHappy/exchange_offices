package com.orange.exchange.service;

import com.orange.exchange.domain.ExchangeRate;
import com.orange.exchange.repository.ExchangeRateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class ExchangeRateService {
    private final ExchangeRateRepository exchangeRateRepository;

    public Flux<ExchangeRate> getAll() {
        return exchangeRateRepository.findAll();
    }

    public Flux<ExchangeRate> getByDateCursAndCurrencyCode(String currencyCode, LocalDate dateCurs) {
        return exchangeRateRepository.findByCurrencyCodeAndDateCurs(currencyCode, dateCurs);
    }

    public Mono<ExchangeRate> getByDateCursAndCurrencyCodeAndExchangeOfficeId(String currencyCode, LocalDate dateCurs, Long exchangeId) {
        return exchangeRateRepository.findByCurrencyCodeAndDateCursAndExchangeOfficeId(currencyCode, dateCurs, exchangeId);
    }

    public Mono<ExchangeRate> addExchangeRateForCurrentDate(ExchangeRate exchangeRate) {
        exchangeRate.setDateCurs(LocalDate.now());
        return exchangeRateRepository.save(exchangeRate);
    }


}
