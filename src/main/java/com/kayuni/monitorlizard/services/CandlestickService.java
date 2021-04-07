package com.kayuni.monitorlizard.services;

import com.kayuni.monitorlizard.models.Candlestick;
import com.kayuni.monitorlizard.dto.CandlestickDTO;
import java.sql.Date;

public interface CandlestickService {
    public void insertCandlestick(CandlestickDTO candlestick);

    public void removeCandlestick(Long id);

    public CandlestickDTO getCandlestick(Date timestamp);

    public String updateCandlestick(Date timestamp, Candlestick candlestick);
}
