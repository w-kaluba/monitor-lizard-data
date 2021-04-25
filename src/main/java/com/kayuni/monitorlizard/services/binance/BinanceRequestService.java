package com.kayuni.monitorlizard.services.binance;

import java.time.Instant;
import java.util.List;
import com.binance.api.client.BinanceApiAsyncRestClient;
import com.binance.api.client.BinanceApiCallback;
import com.binance.api.client.domain.market.Candlestick;
import com.binance.api.client.domain.market.CandlestickInterval;
import com.binance.api.client.impl.BinanceApiAsyncRestClientImpl;
import com.kayuni.monitorlizard.services.ExchangeRequestService;
import com.kayuni.monitorlizard.dto.CandlestickDTO;
import com.kayuni.monitorlizard.models.CandlestickEntity;
import com.kayuni.monitorlizard.repositories.CandlestickRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("binanceRequestService")
public class BinanceRequestService implements ExchangeRequestService {

    @Autowired
    CandlestickRepository repository;
    @Autowired
    BinanceCandlestickService service;

    private Instant startTime;
    @Value("#{environment.BINANCE_API_KEY}")
    private String apiKey;
    @Value("#{environment.BINANCE_API_SECRET}")
    private String apiSecret;
    private BinanceApiAsyncRestClient client;

    BinanceRequestService() {
        this.startTime = Instant.now();
        this.client = new BinanceApiAsyncRestClientImpl(this.apiKey, this.apiSecret);
    }

    BinanceRequestService(Instant startTime) {
        this.startTime = startTime;
        this.client = new BinanceApiAsyncRestClientImpl(this.apiKey, this.apiSecret);
    }

    public void updateCache(String symbol) {
        Long startTime = this.startTime == null ? service.getLastCandlestick().getCloseTime() : this.startTime.toEpochMilli();
        Long endTime = Long.valueOf(Instant.now().toEpochMilli());
        client.getCandlestickBars(symbol, CandlestickInterval.ONE_MINUTE, 500, startTime, endTime, new BinanceUpdateCallback());
    }

    public Instant getStartDate() {
        return this.startTime;

    }

    public void setStartDate(Instant startTime) {
        this.startTime = startTime;
    }

    public void setStartDate() {
        this.startTime = Instant.now();
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


