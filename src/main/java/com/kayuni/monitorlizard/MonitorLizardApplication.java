package com.kayuni.monitorlizard;

import java.util.Calendar;
import java.sql.Date;

import com.kayuni.monitorlizard.dto.CandlestickDTO;
import com.kayuni.monitorlizard.services.BinanceCandlestickService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import ch.qos.logback.core.net.server.Client;

@SpringBootApplication
public class MonitorLizardApplication implements CommandLineRunner {
	static Logger logger = LoggerFactory.getLogger(Client.class);

	@Autowired
	ApplicationContext context;

	@Autowired
	BinanceCandlestickService service;

	@EventListener(ApplicationReadyEvent.class)
	public void runAfterStartup() {
		System.out.println("Run after startup.");
	}

	public static void main(String[] args) {
		SpringApplication.run(MonitorLizardApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Calendar calendar = Calendar.getInstance();

		CandlestickDTO candlestick1 = new CandlestickDTO(new Date(calendar.getTimeInMillis()), Long.valueOf(0L), "open", "high",
				"low", "close", "volume", Long.valueOf(0L), "quoteAssetVolume", Long.valueOf(0L), "takerBuyAssetVolume",
				"takerBuyQuoteAssetVolume");
		Thread.sleep(2000);
		calendar = Calendar.getInstance();
		CandlestickDTO candlestick2 = new CandlestickDTO(new Date(calendar.getTimeInMillis()), Long.valueOf(0L), "open", "high",
				"low", "close", "volume", Long.valueOf(0L), "quoteAssetVolume", Long.valueOf(0L), "takerBuyAssetVolume",
				"takerBuyQuoteAssetVolume");
		Thread.sleep(2000);
		calendar = Calendar.getInstance();
		CandlestickDTO candlestick3 = new CandlestickDTO(new Date(calendar.getTimeInMillis()), Long.valueOf(0L), "open", "high",
				"low", "close", "volume", Long.valueOf(0L), "quoteAssetVolume", Long.valueOf(0L), "takerBuyAssetVolume",
				"takerBuyQuoteAssetVolume");

		service.insertCandlestick(candlestick1);
		service.insertCandlestick(candlestick2);
		service.insertCandlestick(candlestick3);
		logger.info("Candlesticks successfully added");

		logger.info("Printing candlesticks");
		CandlestickDTO candlestickDTO = service.getCandlestick((Date) calendar.getTime());
		logger.info(candlestickDTO.toString());
	}

}
