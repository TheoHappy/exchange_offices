package com.orange.exchange.service;

import com.orange.exchange.domain.Cash;
import com.orange.exchange.repository.CashRepository;
import com.orange.exchange.utils.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CashService {
    private final CashRepository cashRepository;

    public Flux<Cash> getAll() {
        return cashRepository.findAll();
    }

    public Mono<Cash> updateCash(Long id, Cash cash) {
        return cashRepository.findById(id)
                .flatMap(
                cashFromDb -> {
                    cash.setId(cashFromDb.getId());
                    return cashRepository.save(cash);
                }
        ).switchIfEmpty(Mono.error(new EntityNotFoundException("Entity Not Found")));
    }
}
