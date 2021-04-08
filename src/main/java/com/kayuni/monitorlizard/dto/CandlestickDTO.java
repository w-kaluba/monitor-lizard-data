package com.kayuni.monitorlizard.dto;

import com.kayuni.monitorlizard.models.Candlestick;

public class CandlestickDTO {

    private Long openTime;

    private String open;

    private String high;

    private String low;

    private String close;

    private String volume;

    private Long closeTime;

    private String quoteAssetVolume;

    private Long numberOfTrades;

    private String takerBuyBaseAssetVolume;

    private String takerBuyQuoteAssetVolume;

    public CandlestickDTO() {
    }

    public CandlestickDTO(Long openTime, String open, String high, String low, String close,
            String volume, Long closeTime, String quoteAssetVolume, Long numberOfTrades, String takerBuyBaseAssetVolume,
            String takerBuyQuoteAssetVolume) {
        super();
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


    public static Candlestick prepareCandlestickEntity(CandlestickDTO candlestickDTO) {
        Candlestick candlestickEntity = new Candlestick();
        candlestickEntity.setOpenTime(candlestickDTO.getOpenTime());
        candlestickEntity.setOpen(candlestickDTO.getOpen());
        candlestickEntity.setHigh(candlestickDTO.getHigh());
        candlestickEntity.setLow(candlestickDTO.getLow());
        candlestickEntity.setClose(candlestickDTO.getClose());
        candlestickEntity.setVolume(candlestickDTO.getVolume());
        candlestickEntity.setCloseTime(candlestickDTO.getCloseTime());
        candlestickEntity.setQuoteAssetVolume(candlestickDTO.getQuoteAssetVolume());
        candlestickEntity.setNumberOfTrades(candlestickDTO.getNumberOfTrades());
        candlestickEntity.setTakerBuyBaseAssetVolume(candlestickDTO.getTakerBuyBaseAssetVolume());
        candlestickEntity.setTakerBuyQuoteAssetVolume(candlestickDTO.getTakerBuyQuoteAssetVolume());
        return candlestickEntity;
    }

}
