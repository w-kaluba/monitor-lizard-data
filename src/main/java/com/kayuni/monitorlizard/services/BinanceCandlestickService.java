package com.kayuni.monitorlizard.services;

import com.kayuni.monitorlizard.dto.CandlestickDTO;
import com.kayuni.monitorlizard.models.CandlestickEntity;
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
        // TO-DO: 
        System.out.println(repository.findAll().toString());
        CandlestickEntity candlestick = repository.findByOpenTime(openTime).get(0);
        CandlestickDTO candlestickDTO = CandlestickEntity.prepareCandlestickDTO(candlestick);
        return candlestickDTO;
    }

    @Override
    public CandlestickDTO getLastCandlestick() {
        CandlestickEntity candlestick = repository.findTopByOrderByOpenTimeDesc();
        CandlestickDTO candlestickDTO = CandlestickEntity.prepareCandlestickDTO(candlestick);
        return candlestickDTO;
    }
    @Override
    public String updateCandlestick(Long openTime, CandlestickEntity candlestick) {
        CandlestickEntity candlestickEntity = repository.findByOpenTime(openTime).get(0);
        candlestickEntity.updateCandlestickData(candlestick);
        return "The candlestick for :" + openTime.toString() + "has been updated successfully";
    }
     
}
