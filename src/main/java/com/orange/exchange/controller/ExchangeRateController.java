package com.orange.exchange.controller;

import com.orange.exchange.domain.ExchangeRate;
import com.orange.exchange.dto.ExchangeRateDto;
import com.orange.exchange.service.ExchangeRateService;
import com.orange.exchange.utils.TransformerUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.time.LocalDate;


@RestController
@RequiredArgsConstructor
@RequestMapping("/exchangeRate")
public class ExchangeRateController {
    private final ExchangeRateService exchangeRateService;

    @GetMapping
    private ResponseEntity<Flux<ExchangeRateDto>> getAllExchangeRates() {
        return ResponseEntity.ok()
                        .body(exchangeRateService.getAll()
                                .map(TransformerUtils.convertFromExchangeRateEntityToDto));

    }

    @GetMapping("/currentDate")
    private ResponseEntity<Flux<ExchangeRateDto>> getExchangeRateAtCurrentDateForSpecificCurrency(
            @RequestParam(name = "currencyCode") String currencyCode
    ) {
        return ResponseEntity.ok()
                .body(exchangeRateService.getByDateCursAndCurrencyCode(currencyCode, LocalDate.now())
                        .map(TransformerUtils.convertFromExchangeRateEntityToDto));
    }

    @PostMapping
    public ResponseEntity<Mono<ExchangeRate>> addExchangeRateAtCurrentDate(@RequestBody ExchangeRateDto exchangeRateDto) {
        return ResponseEntity.ok()
                .body(exchangeRateService
                        .addExchangeRateForCurrentDate(TransformerUtils.convertFromExchangeRateDtoToEntity.apply(exchangeRateDto)));
    }

}
