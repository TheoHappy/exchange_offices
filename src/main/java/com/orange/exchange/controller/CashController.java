package com.orange.exchange.controller;

import com.orange.exchange.dto.CashDto;
import com.orange.exchange.service.CashService;
import com.orange.exchange.utils.TransformerUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cash")
public class CashController {
    private final CashService cashService;

    @GetMapping
    private ResponseEntity<Flux<CashDto>> getAllCash() {
        return ResponseEntity
                .ok()
                .body(cashService.getAll().map(TransformerUtils.convertFromCashEntityToDto));
    }

    @PutMapping
    private ResponseEntity<Mono<CashDto>> updateCash(@RequestParam(name = "id") Long id, @RequestBody CashDto cashDto) {
        return ResponseEntity
                .ok()
                .body(cashService
                        .updateCash(id, TransformerUtils.convertFromCashDtoToEntity.apply(cashDto))
                        .map(TransformerUtils.convertFromCashEntityToDto));
    }

}
