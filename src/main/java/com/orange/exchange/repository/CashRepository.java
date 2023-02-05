package com.orange.exchange.repository;

import com.orange.exchange.domain.Cash;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CashRepository extends ReactiveCrudRepository<Cash, Long> {
}
