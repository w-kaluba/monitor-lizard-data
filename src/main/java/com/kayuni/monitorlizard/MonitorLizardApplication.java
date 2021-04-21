package com.kayuni.monitorlizard;


import java.util.List;
import java.time.ZonedDateTime;
import java.util.TimeZone;

import com.kayuni.monitorlizard.dto.CandlestickDTO;
import com.kayuni.monitorlizard.services.binance.BinanceCandlestickService;
import com.kayuni.monitorlizard.services.binance.BinanceRequestService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.EventListener;

import ch.qos.logback.core.net.server.Client;

@SpringBootApplication
public class MonitorLizardApplication implements CommandLineRunner {
	static Logger logger = LoggerFactory.getLogger(Client.class);

	@Autowired
	ApplicationContext context;

	@Autowired
	BinanceCandlestickService service;

	@Autowired
	BinanceRequestService requestService;

	// @EventListener(ApplicationReadyEvent.class)
	// public void runAfterStartup() {
	// 	System.out.println("Run after startup.");
	// }

	public static void main(String[] args) {
		SpringApplication.run(MonitorLizardApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ZonedDateTime time = ZonedDateTime.of(2021, 1, 1, 0, 59, 59, 59, TimeZone.getDefault().toZoneId());
		requestService.setStartDate(time.toInstant());
		requestService.updateCache("BTCUSDT");
		List<CandlestickDTO> candlesticks = service.getCandlesticks(time.toInstant().toEpochMilli());
		candlesticks.stream().forEach(candlestick -> logger.info(candlestick.toString()));

		// CandlestickDTO candlestick1 = new CandlestickDTO(Long.valueOf(0L), "open", "high", "low",
		// 		"close", "volume", Long.valueOf(0L), "quoteAssetVolume", Long.valueOf(0L), "takerBuyAssetVolume",
		// 		"takerBuyQuoteAssetVolume");
		// Thread.sleep(2000);
		// CandlestickDTO candlestick2 = new CandlestickDTO(Long.valueOf(0L), "open", "high", "low",
		// 		"close", "volume", Long.valueOf(0L), "quoteAssetVolume", Long.valueOf(0L), "takerBuyAssetVolume",
		// 		"takerBuyQuoteAssetVolume");
		// Thread.sleep(2000);
		// CandlestickDTO candlestick3 = new CandlestickDTO(Long.valueOf(0L), "open", "high", "low",
		// 		"close", "volume", Long.valueOf(0L), "quoteAssetVolume", Long.valueOf(0L), "takerBuyAssetVolume",
		// 		"takerBuyQuoteAssetVolume");
		
		// logger.info("candlestick 3:\t" + candlestick3 + "\n");

		// service.insertCandlestick(candlestick1);
		// service.insertCandlestick(candlestick2);
		// service.insertCandlestick(candlestick3);
		// logger.info("Candlesticks successfully added");

		// logger.info("Printing candlesticks");
		// CandlestickDTO candlestickDTO = service.getCandlestick(Long.valueOf(0));
		// logger.info(candlestickDTO.toString());
	}

}
