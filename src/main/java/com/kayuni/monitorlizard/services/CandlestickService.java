package com.kayuni.monitorlizard.services;

import com.kayuni.monitorlizard.dto.CandlestickDTO;
import com.kayuni.monitorlizard.models.CandlestickEntity;

public interface CandlestickService {
    public void insertCandlestick(CandlestickDTO candlestick);

    public void removeCandlestick(Long openTime);

    public CandlestickDTO getCandlestick(Long openTime);

    public CandlestickDTO getLastCandlestick();

    public String updateCandlestick(Long openTime, CandlestickEntity candlestick);
}
