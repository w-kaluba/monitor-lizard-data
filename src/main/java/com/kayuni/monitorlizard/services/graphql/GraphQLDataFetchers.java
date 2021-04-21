package com.kayuni.monitorlizard.services.graphql;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import graphql.schema.DataFetcher;
import com.kayuni.monitorlizard.services.binance.BinanceCandlestickService;
import com.kayuni.monitorlizard.dto.CandlestickDTO;
import com.kayuni.monitorlizard.models.SymbolEntity;


@Component
public class GraphQLDataFetchers {
    @Autowired
	BinanceCandlestickService candlestickService;

    // @Autowired
    // BinanceSymbolService symbolService;

    public DataFetcher<List<CandlestickDTO>> getCandlesticksByTimeDataFetcher() {
        return dataFetchingEnvironment -> {
            String time = dataFetchingEnvironment.getArgument("time");
            return candlestickService.getCandlesticks(Long.valueOf(time));
        };
    }

    // public DataFetcher<SymbolEntity> getSymbolByNameDataFetcher() {
    //     return dataFetchingEnvironment -> {
    //         String name = dataFetchingEnvironment.getArgument("name");
    //         return symbolService.getSymbolByName(name);
    //     };
    //     };
}
    

