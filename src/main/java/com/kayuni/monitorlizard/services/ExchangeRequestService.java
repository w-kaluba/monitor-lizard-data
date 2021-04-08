package com.kayuni.monitorlizard.services;

import java.time.LocalDateTime;

public interface ExchangeRequestService {

    public void updateCache();
    public LocalDateTime getStartDate();
    public void setStartDate();
    public void setStartDate(LocalDateTime timestamp);

}
