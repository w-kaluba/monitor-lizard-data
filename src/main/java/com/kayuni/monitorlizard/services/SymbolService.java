package com.kayuni.monitorlizard.services;

import java.util.List;
import com.kayuni.monitorlizard.dto.SymbolDTO;
import com.kayuni.monitorlizard.models.SymbolEntity;

public interface SymbolService {
    public void insertSymbol(SymbolDTO symbol);

    public void removeSymbol(String name);

    public SymbolDTO getSymbol(String name);

    public List<SymbolDTO> getSymbols();

    public String updateSymbol(String name, SymbolEntity symbol);
}
