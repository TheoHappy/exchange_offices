package com.orange.exchange.repository;

import com.orange.exchange.domain.ExchangeRate;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

public interface ExchangeRateRepository extends ReactiveCrudRepository<ExchangeRate, Long> {
    Flux<ExchangeRate> findByCurrencyCodeAndDateCurs(String currencyCode, LocalDate dateCurs);
    Mono<ExchangeRate> findByCurrencyCodeAndDateCursAndExchangeOfficeId(String currencyCode, LocalDate dateCurs, Long exchangeId);
}
