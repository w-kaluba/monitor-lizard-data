package com.kayuni.monitorlizard.services;

import java.time.Instant;

public interface ExchangeRequestService {

    public void updateCache(String symbol);
    public Instant getStartDate();
    public void setStartDate();
    public void setStartDate(Instant startTime);

}
