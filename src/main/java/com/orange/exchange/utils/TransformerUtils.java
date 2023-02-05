package com.orange.exchange.utils;

import com.orange.exchange.domain.Cash;
import com.orange.exchange.domain.ExchangeRate;
import com.orange.exchange.domain.Transaction;
import com.orange.exchange.dto.CashDto;
import com.orange.exchange.dto.ExchangeRateDto;
import com.orange.exchange.dto.TransactionRequestDto;
import com.orange.exchange.dto.TransactionResponseDto;
import java.util.function.Function;

public class TransformerUtils {
    public static final Function<ExchangeRateDto, ExchangeRate> convertFromExchangeRateDtoToEntity =
            exchangeRateDto -> ExchangeRate.builder()
                .currencyCode(exchangeRateDto.getCurrencyCode())
                .rate(exchangeRateDto.getRate())
                .course(exchangeRateDto.getCourse())
                .exchangeOfficeId(exchangeRateDto.getExchangeOfficeId())
                .dateCurs(exchangeRateDto.getDateCurs())
                .build();

    public static final Function<ExchangeRate, ExchangeRateDto> convertFromExchangeRateEntityToDto =
            exchangeRateDto -> ExchangeRateDto.builder()
                    .currencyCode(exchangeRateDto.getCurrencyCode())
                    .rate(exchangeRateDto.getRate())
                    .course(exchangeRateDto.getCourse())
                    .exchangeOfficeId(exchangeRateDto.getExchangeOfficeId())
                    .dateCurs(exchangeRateDto.getDateCurs())
                    .build();

    public static final Function<TransactionResponseDto, Transaction> convertFromTransactionsDtoToEntity =
            transactionResponseDto -> Transaction.builder()
                    .consumer(transactionResponseDto.getConsumer())
                    .dateTrans(transactionResponseDto.getDateTrans())
                    .currencyCode(transactionResponseDto.getCurrencyCode())
                    .receivedAmount(transactionResponseDto.getReceivedAmount())
                    .releasedAmount(transactionResponseDto.getReleasedAmount())
                    .exchangeOfficeId(transactionResponseDto.getExchangeOfficeId())
                    .build();

    public static final Function<TransactionRequestDto, Transaction> convertFromTransactionsRequestDtoToEntity =
            transactionResponseDto -> Transaction.builder()
                    .consumer(transactionResponseDto.getConsumer())
                    .dateTrans(transactionResponseDto.getDateTrans())
                    .currencyCode(transactionResponseDto.getCurrencyCode())
                    .receivedAmount(transactionResponseDto.getReceivedAmount())
                    .exchangeOfficeId(transactionResponseDto.getExchangeOfficeId())
                    .build();

    public static final Function<Transaction, TransactionResponseDto> convertFromTransactionsEntityToResponseDto =
            transaction -> TransactionResponseDto.builder()
                    .consumer(transaction.getConsumer())
                    .dateTrans(transaction.getDateTrans())
                    .currencyCode(transaction.getCurrencyCode())
                    .receivedAmount(transaction.getReceivedAmount())
                    .releasedAmount(transaction.getReleasedAmount())
                    .exchangeOfficeId(transaction.getExchangeOfficeId())
                    .build();

    public static final Function<TransactionResponseDto, Transaction> convertFromTransactionResponseToEntity =
            transaction -> Transaction.builder()
                    .consumer(transaction.getConsumer())
                    .dateTrans(transaction.getDateTrans())
                    .currencyCode(transaction.getCurrencyCode())
                    .receivedAmount(transaction.getReceivedAmount())
                    .releasedAmount(transaction.getReleasedAmount())
                    .exchangeOfficeId(transaction.getExchangeOfficeId())
                    .build();

    public static final Function<TransactionRequestDto, TransactionResponseDto> convertFromTransactionsRequestToResponseDto =
            transactionRequestDto -> TransactionResponseDto.builder()
                    .consumer(transactionRequestDto.getConsumer())
                    .dateTrans(transactionRequestDto.getDateTrans())
                    .currencyCode(transactionRequestDto.getCurrencyCode())
                    .receivedAmount(transactionRequestDto.getReceivedAmount())
                    .exchangeOfficeId(transactionRequestDto.getExchangeOfficeId())
                    .build();

    public static final Function<CashDto, Cash> convertFromCashDtoToEntity =
            cashDto -> Cash.builder()
                    .amount(cashDto.getAmount())
                    .date(cashDto.getDate())
                    .consumer(cashDto.getConsumer())
                    .currencyCode(cashDto.getCurrencyCode())
                    .exchangeOfficeId(cashDto.getExchangeOfficeId())
                    .build();

    public static final Function<Cash, CashDto> convertFromCashEntityToDto =
            cash -> CashDto.builder()
                    .amount(cash.getAmount())
                    .date(cash.getDate())
                    .consumer(cash.getConsumer())
                    .currencyCode(cash.getCurrencyCode())
                    .exchangeOfficeId(cash.getExchangeOfficeId())
                    .build();
}
