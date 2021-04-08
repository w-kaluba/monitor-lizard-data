package com.kayuni.monitorlizard.services;

import java.time.LocalDateTime;

public class BinanceRequestService implements ExchangeRequestService {

    private LocalDateTime startDate;
    private String apiKey;
    private String apiSecret;

    BinanceRequestService() {

    }

    public void updateCache() {

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
}
