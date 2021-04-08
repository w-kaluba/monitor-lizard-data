package com.kayuni.monitorlizard.services;

import java.sql.Date;

import com.kayuni.monitorlizard.repositories.CandlestickRepository;
import java.util.Optional;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kayuni.monitorlizard.models.Candlestick;
import com.kayuni.monitorlizard.dto.CandlestickDTO;

@Service("binanceCandlestickService")
public class BinanceCandlestickService implements CandlestickService {

    @Autowired
    private CandlestickRepository repository;

    @Override
    public void insertCandlestick(CandlestickDTO candlestick) {
        repository.saveAndFlush(CandlestickDTO.prepareCandlestickEntity(candlestick));
    }

    @Override
    public void removeCandlestick(Long id) {
        repository.deleteById(id);
    }

    @Override
    public CandlestickDTO getCandlestick(Date timestamp) {
        System.out.println(repository.findAll().toString());
        Candlestick candlestick = repository.findByTimestamp(timestamp).get(0);
        CandlestickDTO candlestickDTO = Candlestick.prepareCandlestickDTO(candlestick);
        return candlestickDTO;
    }

    @Override
    public String updateCandlestick(Date timestamp, Candlestick candlestick) {
        Candlestick candlestickEntity = repository.findByTimestamp(timestamp).get(0);
        candlestickEntity.updateCandlestickData(candlestick);
        return "The candlestick for :" + timestamp.toString() + "has been updated successfully";
    }
     
}
