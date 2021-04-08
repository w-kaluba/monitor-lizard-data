package com.kayuni.monitorlizard.services;

import com.kayuni.monitorlizard.dto.CandlestickDTO;
import com.kayuni.monitorlizard.models.Candlestick;

public interface CandlestickService {
    public void insertCandlestick(CandlestickDTO candlestick);

    public void removeCandlestick(Long openTime);

    public CandlestickDTO getCandlestick(Long openTime);

    public String updateCandlestick(Long openTime, Candlestick candlestick);
}
