package com.orange.exchange.service;

import com.orange.exchange.domain.CurrencyDictionary;
import com.orange.exchange.repository.CurrencyDictionaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class CurrencyDictionaryService {
    private final CurrencyDictionaryRepository currencyDictionaryRepository;

    public Flux<CurrencyDictionary> getAll() {
        return currencyDictionaryRepository.findAll();
    }
}
