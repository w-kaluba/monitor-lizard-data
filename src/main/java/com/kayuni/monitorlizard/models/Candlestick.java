package com.kayuni.monitorlizard.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.kayuni.monitorlizard.dto.CandlestickDTO;

import javax.persistence.SequenceGenerator;

@Entity
@Table(name = "binance")
public class Candlestick {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private Date timestamp;

    @Column(name = "openTime", nullable = false)
    private Long openTime;

    @Column(name = "open", nullable = false)
    private String open;

    @Column(name = "high", nullable = false)
    private String high;

    @Column(name = "low", nullable = false)
    private String low;

    @Column(name = "close", nullable = false)
    private String close;

    @Column(name = "volume", nullable = false)
    private String volume;

    @Column(name = "closeTime", nullable = false)
    private Long closeTime;

    @Column(name = "quoteAssetVolume", nullable = false)
    private String quoteAssetVolume;

    @Column(name = "numberOfTrades", nullable = false)
    private Long numberOfTrades;

    @Column(name = "takerBuyBaseAssetVolume", nullable = false)
    private String takerBuyBaseAssetVolume;

    @Column(name = "takerBuyQuoteAssetVolume", nullable = false)
    private String takerBuyQuoteAssetVolume;

    public Candlestick() {
    }

    public Candlestick(Date timestamp, Long openTime, String open, String high, String low, String close, String volume,
            Long closeTime, String quoteAssetVolume, Long numberOfTrades, String takerBuyBaseAssetVolume,
            String takerBuyQuoteAssetVolume) {
        this.timestamp = timestamp;
        this.openTime = openTime;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
        this.closeTime = closeTime;
        this.quoteAssetVolume = quoteAssetVolume;
        this.numberOfTrades = numberOfTrades;
        this.takerBuyBaseAssetVolume = takerBuyBaseAssetVolume;
        this.takerBuyQuoteAssetVolume = takerBuyQuoteAssetVolume;
    }

    public Date getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Long getOpenTime() {
        return this.openTime;
    }

    public void setOpenTime(Long openTime) {
        this.openTime = openTime;
    }

    public String getOpen() {
        return this.open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getHigh() {
        return this.high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getLow() {
        return this.low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getClose() {
        return this.close;
    }

    public void setClose(String close) {
        this.close = close;
    }

    public String getVolume() {
        return this.volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public Long getCloseTime() {
        return this.closeTime;
    }

    public void setCloseTime(Long closeTime) {
        this.closeTime = closeTime;
    }

    public String getQuoteAssetVolume() {
        return this.quoteAssetVolume;
    }

    public void setQuoteAssetVolume(String quoteAssetVolume) {
        this.quoteAssetVolume = quoteAssetVolume;
    }

    public Long getNumberOfTrades() {
        return this.numberOfTrades;
    }

    public void setNumberOfTrades(Long numberOfTrades) {
        this.numberOfTrades = numberOfTrades;
    }

    public String getTakerBuyBaseAssetVolume() {
        return this.takerBuyBaseAssetVolume;
    }

    public void setTakerBuyBaseAssetVolume(String takerBuyBaseAssetVolume) {
        this.takerBuyBaseAssetVolume = takerBuyBaseAssetVolume;
    }

    public String getTakerBuyQuoteAssetVolume() {
        return this.takerBuyQuoteAssetVolume;
    }

    public void setTakerBuyQuoteAssetVolume(String takerBuyQuoteAssetVolume) {
        this.takerBuyQuoteAssetVolume = takerBuyQuoteAssetVolume;
    }

    public void updateCandlestickData(Candlestick candlestick) {
        this.timestamp = candlestick.timestamp;
        this.openTime = candlestick.openTime;
        this.open = candlestick.open;
        this.high = candlestick.high;
        this.low = candlestick.low;
        this.close = candlestick.close;
        this.volume = candlestick.volume;
        this.closeTime = candlestick.closeTime;
        this.quoteAssetVolume = candlestick.quoteAssetVolume;
        this.numberOfTrades = candlestick.numberOfTrades;
        this.takerBuyBaseAssetVolume = candlestick.takerBuyBaseAssetVolume;
        this.takerBuyQuoteAssetVolume = candlestick.takerBuyQuoteAssetVolume;
    }

    @Override
    public String toString() {
        return "{" + " timestamp='" + getTimestamp() + "'" + ", openTime='" + getOpenTime() + "'" + ", open='"
                + getOpen() + "'" + ", high='" + getHigh() + "'" + ", low='" + getLow() + "'" + ", close='" + getClose()
                + "'" + ", volume='" + getVolume() + "'" + ", closeTime='" + getCloseTime() + "'"
                + ", quoteAssetVolume='" + getQuoteAssetVolume() + "'" + ", numberOfTrades='" + getNumberOfTrades()
                + "'" + ", takerBuyBaseAssetVolume='" + getTakerBuyBaseAssetVolume() + "'"
                + ", takerBuyQuoteAssetVolume='" + getTakerBuyQuoteAssetVolume() + "'" + "}";
    }

    public static CandlestickDTO prepareCandlestickDTO(Candlestick candlestick) {
        CandlestickDTO candlestickDTO = new CandlestickDTO();
        candlestickDTO.setTimestamp(candlestick.getTimestamp());
        candlestickDTO.setOpenTime(candlestick.getOpenTime());
        candlestickDTO.setOpen(candlestick.getOpen());
        candlestickDTO.setHigh(candlestick.getHigh());
        candlestickDTO.setLow(candlestick.getLow());
        candlestickDTO.setClose(candlestick.getClose());
        candlestickDTO.setVolume(candlestick.getVolume());
        candlestickDTO.setCloseTime(candlestick.getCloseTime());
        candlestickDTO.setNumberOfTrades(candlestick.getNumberOfTrades());
        candlestickDTO.setTakerBuyBaseAssetVolume(candlestick.getTakerBuyBaseAssetVolume());
        candlestickDTO.setTakerBuyQuoteAssetVolume(candlestick.getTakerBuyQuoteAssetVolume());
        return candlestickDTO;
    }

}
