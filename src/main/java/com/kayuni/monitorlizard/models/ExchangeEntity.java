package com.kayuni.monitorlizard.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="exchanges")
public class ExchangeEntity {
    @Id
    @Column(name="name")
    private String name;


    public ExchangeEntity() {
    }

    public ExchangeEntity(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            "}";
    }

    
}
