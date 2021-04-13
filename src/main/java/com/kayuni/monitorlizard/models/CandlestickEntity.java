package com.kayuni.monitorlizard.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.binance.api.client.domain.market.Candlestick;
import com.kayuni.monitorlizard.dto.CandlestickDTO;

@Entity
@Table(name = "binance")
public class CandlestickEntity {

    @Id
    @Column(name = "openTime")
    private Long openTime;

    @Column(name = "open")
    private String open;

    @Column(name = "high")
    private String high;

    @Column(name = "low")
    private String low;

    @Column(name = "close")
    private String close;

    @Column(name = "volume")
    private String volume;

    @Column(name = "closeTime")
    private Long closeTime;

    @Column(name = "quoteAssetVolume", nullable = false)
    private String quoteAssetVolume;

    @Column(name = "numberOfTrades")
    private Long numberOfTrades;

    @Column(name = "takerBuyBaseAssetVolume")
    private String takerBuyBaseAssetVolume;

    @Column(name = "takerBuyQuoteAssetVolume")
    private String takerBuyQuoteAssetVolume;


    public CandlestickEntity() {
    }

    public CandlestickEntity(Long openTime, String open, String high, String low, String close, String volume, Long closeTime, String quoteAssetVolume, Long numberOfTrades, String takerBuyBaseAssetVolume, String takerBuyQuoteAssetVolume) {
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

    public void updateCandlestickData(CandlestickEntity candlestick) {
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
        return "{" +
            " openTime='" + getOpenTime() + "'" +
            ", open='" + getOpen() + "'" +
            ", high='" + getHigh() + "'" +
            ", low='" + getLow() + "'" +
            ", close='" + getClose() + "'" +
            ", volume='" + getVolume() + "'" +
            ", closeTime='" + getCloseTime() + "'" +
            ", quoteAssetVolume='" + getQuoteAssetVolume() + "'" +
            ", numberOfTrades='" + getNumberOfTrades() + "'" +
            ", takerBuyBaseAssetVolume='" + getTakerBuyBaseAssetVolume() + "'" +
            ", takerBuyQuoteAssetVolume='" + getTakerBuyQuoteAssetVolume() + "'" +
            "}";
    }
    
    public static CandlestickDTO prepareCandlestickDTO(CandlestickEntity candlestick) {
        CandlestickDTO candlestickDTO = new CandlestickDTO();
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

    public static CandlestickDTO prepareCandlestickDTO(Candlestick candlestick) {
        CandlestickDTO candlestickDTO = new CandlestickDTO();
        candlestickDTO.setOpenTime(candlestick.getOpenTime());
        candlestickDTO.setOpen(candlestick.getOpen());
        candlestickDTO.setHigh(candlestick.getHigh());
        candlestickDTO.setLow(candlestick.getLow());
        candlestickDTO.setClose(candlestick.getClose());
        candlestickDTO.setVolume(candlestick.getVolume());
        candlestickDTO.setQuoteAssetVolume(candlestick.getQuoteAssetVolume());
        candlestickDTO.setCloseTime(candlestick.getCloseTime());
        candlestickDTO.setNumberOfTrades(candlestick.getNumberOfTrades());
        candlestickDTO.setTakerBuyBaseAssetVolume(candlestick.getTakerBuyBaseAssetVolume());
        candlestickDTO.setTakerBuyQuoteAssetVolume(candlestick.getTakerBuyQuoteAssetVolume());
        return candlestickDTO;
    }

}
