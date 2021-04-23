package com.kayuni.monitorlizard.services.binance;

import java.util.List;
import java.util.stream.Collectors;

import com.kayuni.monitorlizard.dto.SymbolDTO;
import com.kayuni.monitorlizard.models.SymbolEntity;
import com.kayuni.monitorlizard.repositories.SymbolRepository;
import com.kayuni.monitorlizard.services.SymbolService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("binanceSymbolService")
public class BinanceSymbolService implements SymbolService {

    @Autowired
    private SymbolRepository repository;

    public void insertSymbol(SymbolDTO symbol) {
        repository.saveAndFlush(SymbolDTO.prepareSymbolEntity(symbol));
    }

    public void removeSymbol(String name) {
        repository.deleteByName(name);
    }

    public SymbolDTO getSymbol(String name) {
        return SymbolEntity.prepareSymbolDTO(repository.findByName(name).get(0));
    }

    public List<SymbolDTO> getSymbols() {
        List<SymbolEntity> symbols = repository.findAll();
        return symbols.stream()
            .map(symbol -> SymbolEntity.prepareSymbolDTO(symbol))
            .collect(Collectors.toList());

    };

    public String updateSymbol(String name, SymbolEntity symbol) {
        return "success";
    };
}
