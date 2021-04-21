package com.kayuni.monitorlizard.dto;

import com.kayuni.monitorlizard.models.SymbolEntity;

public class SymbolDTO {
    private String name;

    private String change;

    private String high;

    private String low;

    private String volume;


    public SymbolDTO() {
    }

    public SymbolDTO(String name, String change, String high, String low, String volume) {
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

    public SymbolDTO name(String name) {
        setName(name);
        return this;
    }

    public SymbolDTO change(String change) {
        setChange(change);
        return this;
    }

    public SymbolDTO high(String high) {
        setHigh(high);
        return this;
    }

    public SymbolDTO low(String low) {
        setLow(low);
        return this;
    }

    public SymbolDTO volume(String volume) {
        setVolume(volume);
        return this;
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

    public static SymbolEntity prepareSymbolEntity(SymbolDTO symbolDTO) {
        SymbolEntity symbolEntity = new SymbolEntity();
        symbolEntity.setName(symbolDTO.getName());
        symbolEntity.setChange(symbolDTO.getChange());
        symbolEntity.setHigh(symbolDTO.getHigh());
        symbolEntity.setLow(symbolDTO.getLow());
        symbolEntity.setVolume(symbolDTO.getVolume());
        return symbolEntity;
    }


}
