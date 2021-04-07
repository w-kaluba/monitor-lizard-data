package com.kayuni.monitorlizard.services;

import java.sql.Timestamp;

public interface ExchangeRequestService {

    public void updateCache();
    public Timestamp getStartDate();
    public void setStartDate();
    public void setStartDate(Timestamp timestamp);

}
