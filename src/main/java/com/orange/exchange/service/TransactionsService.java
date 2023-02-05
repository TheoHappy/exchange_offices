package com.orange.exchange.service;

import com.orange.exchange.domain.ExchangeRate;
import com.orange.exchange.domain.Transaction;
import com.orange.exchange.dto.TransactionRequestDto;
import com.orange.exchange.repository.TransactionsRepository;
import com.orange.exchange.utils.TransformerUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
@RequiredArgsConstructor
public class TransactionsService {
    private final TransactionsRepository transactionsRepository;
    private final ExchangeRateService exchangeRateService;

    public Flux<Transaction> getAll() {
        transactionsRepository.findAll().subscribe(System.out::println);
        return transactionsRepository.findAll();
    }

    @Transactional
    public Mono<Transaction> addTransaction(TransactionRequestDto transactionRequestDto) {
        var transaction = TransformerUtils.convertFromTransactionsRequestDtoToEntity.apply(transactionRequestDto);

        return exchangeRateService.getByDateCursAndCurrencyCodeAndExchangeOfficeId(
                        transactionRequestDto.getCurrencyCode(),
                        transactionRequestDto.getDateTrans(),
                        transactionRequestDto.getExchangeOfficeId()
                )
                .flatMap(exchangeRate -> transactionsRepository.save(calculateAmounts(exchangeRate, transaction)));
    }

    private Transaction calculateAmounts(ExchangeRate exchangeRate, Transaction transaction) {
        transaction.setReleasedAmount((exchangeRate.getCourse() * transaction.getReceivedAmount()) / exchangeRate.getRate());
        transaction.setExchangeRateId(exchangeRate.getId());

        return transaction;
    }
}
