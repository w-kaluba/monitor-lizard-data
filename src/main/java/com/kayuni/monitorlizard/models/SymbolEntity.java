package com.kayuni.monitorlizard.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.kayuni.monitorlizard.dto.SymbolDTO;

@Entity
@Table(name = "binance")
public class SymbolEntity {

    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "change")
    private String change;

    @Column(name = "high")
    private String high;

    @Column(name = "low")
    private String low;

    @Column(name = "volume")
    private String volume;


    public SymbolEntity() {
    }

    public SymbolEntity(String name, String change, String high, String low, String volume) {
        this.name = name;
        this.change = change;
        this.high = high;
        this.low = low;
        this.volume = volume;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChange() {
        return this.change;
    }

    public void setChange(String change) {
        this.change = change;
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

    public String getVolume() {
        return this.volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public void updateSymbolData(SymbolEntity candlestick) {
        this.name = candlestick.name;
        this.change = candlestick.change;
        this.high = candlestick.high;
        this.low = candlestick.low;
        this.volume = candlestick.volume;
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", change='" + getChange() + "'" +
            ", high='" + getHigh() + "'" +
            ", low='" + getLow() + "'" +
            ", volume='" + getVolume() + "'" +
            "}";
    }
    
    
    public static SymbolDTO prepareCandlestickDTO(SymbolEntity symbol) {
        SymbolDTO symbolDTO = new SymbolDTO();
        symbolDTO.setName(symbol.getName());
        symbolDTO.setChange(symbol.getChange());
        symbolDTO.setHigh(symbol.getHigh());
        symbolDTO.setLow(symbol.getLow());
        symbolDTO.setVolume(symbol.getVolume());
        return symbolDTO;
    }

}
