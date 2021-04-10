package com.kayuni.monitorlizard.services;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import com.binance.api.client.BinanceApiAsyncRestClient;
import com.binance.api.client.BinanceApiCallback;
import com.binance.api.client.domain.market.Candlestick;
import com.binance.api.client.domain.market.CandlestickInterval;
import com.binance.api.client.impl.BinanceApiAsyncRestClientImpl;
import com.kayuni.monitorlizard.dto.CandlestickDTO;
import com.kayuni.monitorlizard.models.CandlestickEntity;
import com.kayuni.monitorlizard.repositories.CandlestickRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class BinanceRequestService implements ExchangeRequestService {

    @Autowired
    CandlestickRepository repository;
    @Autowired
    BinanceCandlestickService service;

    private LocalDateTime startDate;
    @Value("${BINANCE_API_KEY}")
    private String apiKey;
    @Value("${BINANCE_API_KEY}")
    private String apiSecret;
    private BinanceApiAsyncRestClient client;

    BinanceRequestService() {
        this.startDate = LocalDateTime.now();
        this.client = new BinanceApiAsyncRestClientImpl(this.apiKey, this.apiSecret);
    }

    BinanceRequestService(LocalDateTime startDate) {
        this.startDate = startDate;
        this.client = new BinanceApiAsyncRestClientImpl(this.apiKey, this.apiSecret);
    }

    public void updateCache(String symbol) {
        Long startTime = service.getLastCandlestick().getCloseTime();
        Long endTime = Long.valueOf(Instant.now().toEpochMilli());
        client.getCandlestickBars(symbol, CandlestickInterval.ONE_MINUTE, 500, startTime, endTime, new BinanceUpdateCallback());
    }

    public LocalDateTime getStartDate() {
        return this.startDate;

    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public void setStartDate() {
        this.startDate = LocalDateTime.now();
    }

    public String getApiKey() {
        return this.apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getApiSecret() {
        return this.apiSecret;
    }

    public void setApiSecret(String apiSecret) {
        this.apiSecret = apiSecret;
    }

    class BinanceUpdateCallback implements BinanceApiCallback<List<Candlestick>> {
        public void onResponse(List<Candlestick> response) {
            response.forEach(candlestick -> {
                CandlestickDTO candlestickDTO = CandlestickEntity.prepareCandlestickDTO(candlestick);
                service.insertCandlestick(candlestickDTO);
            });
        }
    }

}


