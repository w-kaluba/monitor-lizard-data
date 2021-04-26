package com.kayuni.monitorlizard.services.graphql;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import graphql.schema.DataFetcher;
import com.kayuni.monitorlizard.services.binance.BinanceCandlestickService;
import com.kayuni.monitorlizard.services.binance.BinanceSymbolService;
import com.kayuni.monitorlizard.dto.CandlestickDTO;
import com.kayuni.monitorlizard.dto.SymbolDTO;

@Component
public class GraphQLDataFetchers {
    @Autowired
    BinanceCandlestickService candlestickService;

    @Autowired
    BinanceSymbolService symbolService;

    public DataFetcher<List<CandlestickDTO>> getAllCandlesticksDataFetcher() {
        return dataFetchingEnvironment -> {
            return candlestickService.getCandlesticks(Long.valueOf(0));
        };
    }

    public DataFetcher<List<CandlestickDTO>> getCandlesticksByTimeDataFetcher() {
        return dataFetchingEnvironment -> {
            Long time = dataFetchingEnvironment.getArgument("time");
            return candlestickService.getCandlesticks(Long.valueOf(time));
        };
    }

    public DataFetcher<SymbolDTO> getSymbolByNameDataFetcher() {
        return dataFetchingEnvironment -> {
            String name = dataFetchingEnvironment.getArgument("name");
            return symbolService.getSymbol(name);
        };
    };
}