package com.orange.exchange.repository;

import com.orange.exchange.domain.CurrencyDictionary;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CurrencyDictionaryRepository extends ReactiveCrudRepository<CurrencyDictionary, String> {
}
