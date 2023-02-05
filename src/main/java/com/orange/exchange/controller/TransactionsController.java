package com.orange.exchange.controller;

import com.orange.exchange.dto.TransactionRequestDto;
import com.orange.exchange.dto.TransactionResponseDto;
import com.orange.exchange.service.TransactionsService;
import com.orange.exchange.utils.TransformerUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transactions")
public class TransactionsController {
    private final TransactionsService transactionsService;

    @GetMapping
    private ResponseEntity<Flux<TransactionResponseDto>> getAllExchangeRates() {
        return ResponseEntity.ok()
                .body(transactionsService.getAll()
                        .map(TransformerUtils.convertFromTransactionsEntityToResponseDto));

    }

    @PostMapping
    public ResponseEntity<Mono<TransactionResponseDto>> addExchangeRate(
            @RequestBody TransactionRequestDto transactionRequestDto) {
        return ResponseEntity.ok()
                .body(transactionsService
                        .addTransaction(transactionRequestDto)
                        .map(TransformerUtils.convertFromTransactionsEntityToResponseDto));
    }
}
