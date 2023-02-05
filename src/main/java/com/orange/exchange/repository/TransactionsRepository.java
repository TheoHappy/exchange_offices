package com.orange.exchange.repository;

import com.orange.exchange.domain.Transaction;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface TransactionsRepository extends ReactiveCrudRepository<Transaction, Long> {
}
