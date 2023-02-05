package com.orange.exchange.controller;

import com.orange.exchange.domain.CurrencyDictionary;
import com.orange.exchange.service.CurrencyDictionaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
@RequestMapping("/currencies")
public class CurrencyDictionaryController {
    private final CurrencyDictionaryService currencyDictionaryService;

    @GetMapping
    private ResponseEntity<Flux<CurrencyDictionary>> getAllCurrencies() {
        return ResponseEntity.ok()
                .body(currencyDictionaryService.getAll());
    }
}
