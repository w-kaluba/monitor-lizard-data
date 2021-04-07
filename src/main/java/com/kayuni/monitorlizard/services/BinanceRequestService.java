package com.kayuni.monitorlizard.services;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;

public class BinanceRequestService implements ExchangeRequestService {
    
    private Timestamp startDate;
    private String apiKey;
    private String apiSecret;

    BinanceRequestService() {

    }

    public void updateCache() {

    }

    public Timestamp getStartDate() {
        return this.startDate;

    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public void setStartDate() {
        this.startDate = (Timestamp) Calendar.getInstance().getTime();
    }
}
