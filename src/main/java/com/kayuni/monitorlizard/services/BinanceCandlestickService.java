package com.kayuni.monitorlizard.services;

import com.kayuni.monitorlizard.dto.CandlestickDTO;
import com.kayuni.monitorlizard.models.Candlestick;
import com.kayuni.monitorlizard.repositories.CandlestickRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public CandlestickDTO getCandlestick(Long openTime) {
        System.out.println(repository.findAll().toString());
        Candlestick candlestick = repository.findAll().get(0);
        CandlestickDTO candlestickDTO = Candlestick.prepareCandlestickDTO(candlestick);
        return candlestickDTO;
    }

    @Override
    public String updateCandlestick(Long openTime, Candlestick candlestick) {
        Candlestick candlestickEntity = repository.findByOpenTime(openTime).get(0);
        candlestickEntity.updateCandlestickData(candlestick);
        return "The candlestick for :" + openTime.toString() + "has been updated successfully";
    }
     
}
